package io.spring.initializr.generator.spring.logback;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

import io.spring.initializr.generator.io.template.MustacheTemplateRenderer;
import io.spring.initializr.generator.project.contributor.ProjectContributor;
import io.spring.initializr.generator.spring.util.GeneratorConstants;

public class LogbackProjectContributor implements ProjectContributor {

    private final MustacheTemplateRenderer templateRenderer;

    public LogbackProjectContributor(MustacheTemplateRenderer templateRenderer) {
        this.templateRenderer = templateRenderer;
    }

    @Override
    public void contribute(Path projectRoot) throws IOException {
        // devops/deploy-dev.yml
        // devops/deploy-prod.yml
        // JenkinsfileDev.mustache
        // JenkinsfileProd.mustache
        // Dockerfile

        Files.createDirectories(projectRoot.resolve("src/main/resources/logback"));

//        Path logbackDir = Files.createDirectory(projectRoot.resolve("src/main/resources/logback"));
//        Path resourcesDir = Files.createDirectory(projectRoot.resolve("src/main/resources"));

        Path logbackDir = projectRoot.resolve("src/main/resources/logback");
        Path resourcesDir = projectRoot.resolve("src/main/resources");

        Path mainLogbackReferenceOutput = Files.createFile(resourcesDir.resolve("logback.xml"));
        Path fileLogbackReferenceOutput = Files.createFile(logbackDir.resolve("file-logback.xml"));
        Path consoleLogbackReferenceOuput = Files.createFile(logbackDir.resolve("console-logback.xml"));



        Files.write(mainLogbackReferenceOutput,
                templateRenderer.render(GeneratorConstants.getMainFileLogbackTemplate().toString(), new HashMap<>()).getBytes());

        Files.write(consoleLogbackReferenceOuput,
                templateRenderer.render(GeneratorConstants.getConsoleLogbackTemplate().toString(), new HashMap<>()).getBytes());

        Files.write(fileLogbackReferenceOutput,
                templateRenderer.render(GeneratorConstants.getFileLogbackTemplate().toString(), new HashMap<>()).getBytes());
//
//        // Copiar el archivo desde la plantilla al destino en el proyecto
//        Files.copy(
//                templateRenderer.render(GeneratorConstants.getDevOpsDevTemplate().toString(), new HashMap<>())
//                , fileLogbackReferenceOutput, StandardCopyOption.REPLACE_EXISTING);
//        Files.copy(GeneratorConstants.getMainFileLogbackTemplate(), mainLogbackReferenceOutput, StandardCopyOption.REPLACE_EXISTING);
//        Files.copy(GeneratorConstants.getConsoleLogbackTemplate(), consoleLogbackReferenceOuput, StandardCopyOption.REPLACE_EXISTING);
    }
}
