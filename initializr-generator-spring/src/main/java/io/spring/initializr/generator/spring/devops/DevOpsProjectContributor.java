package io.spring.initializr.generator.spring.devops;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import io.spring.initializr.generator.io.template.MustacheTemplateRenderer;
import io.spring.initializr.generator.project.contributor.ProjectContributor;
import io.spring.initializr.generator.spring.util.GeneratorConstants;

public class DevOpsProjectContributor implements ProjectContributor {

    private final MustacheTemplateRenderer templateRenderer;

    public DevOpsProjectContributor(MustacheTemplateRenderer templateRenderer) {
        this.templateRenderer = templateRenderer;
    }

    @Override
    public void contribute(Path projectRoot) throws IOException {
        // devops/deploy-dev.yml
        // devops/deploy-prod.yml
        // JenkinsfileDev.mustache
        // JenkinsfileProd.mustache
        // Dockerfile
        Path devopsDir = Files.createDirectory(projectRoot.resolve("devops"));
        Path devopsDevFile = Files.createFile(devopsDir.resolve("devops-dev.yaml"));
        Path devopsProdFile = Files.createFile(devopsDir.resolve("deploy-prod.yaml"));
        Path jenkinsDevFile = Files.createFile(projectRoot.resolve("JenkinsDevfile"));
        Path jenkinsProdFile = Files.createFile(projectRoot.resolve("JenkinsProdfile"));
        Path dockerFile = Files.createFile(projectRoot.resolve("Dockerfile"));

        // servicePort
        Map<String, Object> model = new HashMap<>();
        model.put("mountPathTemplate", "\"/tmp/logs/\" # REPLACE WITH YOUR MOUNT PATH, ADD OTHERS OR REMOVE IT..");
        model.put("storageSize", "1Gi # REPLACE WITH YOUR STORAGE SIZE OR REMOVE IT..");
        model.put("protocol", "TCP");
        model.put("servicePort", "9002 #REPLACE THIS PORT WITH YOUR SERVICE PORT");
        model.put("targetPort", "9002 #REPLACE THIS PORT WITH YOUR TARGET PORT");
        model.put("nodePort", "30000 #REPLACE THIS PORT WITH YOUR NODE PORT");
        model.put("applicationName", "'YOUR_APP_NAME' #REPLACE THIS WITH YOUR APPNAME");
        model.put("HVToken", "'vault://secret-ENVIRONMENT_TYPE/YOUR_TOKEN' #REPLACE THIS WITH YOUR TOKEN");
        model.put("applicationPath", "'YOUR_APPLICATION_PATH' #REPLACE THIS WITH YOUR APPLICATION PATH OF HASHICORPVAULT");
        model.put("kubernetesSecret", "'YOUR_KUBERNETES_SECRET_ALIAS' #REPLACE THIS WITH YOUR KUBERNETES IDENTIFICATOR OF JENKINS");
        model.put("registryImageWithName", "registrydev-service.abexa.pe/YOUR_APP_NAME #REPLACE THIS WITH YOUR APPNAME");

        // jenkinsfiledev
        model.put("deployDevFileName", "devops-dev.yaml.mustache");
        model.put("deployProdFileName", "deploy-prod.yaml");

        Files.write(devopsDevFile,
                templateRenderer.render(GeneratorConstants.getDevOpsDevTemplate().toString(), model).getBytes());
        Files.write(devopsProdFile,
                templateRenderer.render(GeneratorConstants.getDevOpsProdTemplate().toString(), model).getBytes());
        Files.write(jenkinsDevFile,
                templateRenderer.render(GeneratorConstants.getJenkinsfileDevTemplate().toString(), model).getBytes());
        Files.write(jenkinsProdFile,
                templateRenderer.render(GeneratorConstants.getJenkinsfileProdTemplate().toString(), model).getBytes());
        Files.write(dockerFile,
                templateRenderer.render(GeneratorConstants.getDockerfileTemplate().toString(), model).getBytes());
    }
}
