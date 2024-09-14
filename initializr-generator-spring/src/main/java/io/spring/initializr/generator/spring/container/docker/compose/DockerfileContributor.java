package io.spring.initializr.generator.spring.container.docker.compose;

import io.spring.initializr.generator.buildsystem.BuildSystem;
import io.spring.initializr.generator.io.template.MustacheTemplateRenderer;
import io.spring.initializr.generator.project.ProjectGenerationConfiguration;
import io.spring.initializr.generator.project.contributor.ProjectContributor;
import io.spring.initializr.generator.spring.util.GeneratorConstants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@ProjectGenerationConfiguration
public class DockerfileContributor implements ProjectContributor {

    private final MustacheTemplateRenderer templateRenderer;

    public DockerfileContributor(MustacheTemplateRenderer templateRenderer) {
        this.templateRenderer = templateRenderer;
    }

    @Override
    public void contribute(Path projectRoot) throws IOException {
        // Crear directorios adicionales, por ejemplo 'docker'
//        Path dockerDir = Files.createDirectory(projectRoot.resolve("docker"));
        // Crear el Dockerfile en el directorio 'docker'
//        Path dockerFile = Files.createFile(dockerDir.resolve("Dockerfile"));
        Path dockerFile = Files.createFile(projectRoot.resolve("Dockerfile"));

        Map<String, Object> model = new HashMap<>();
//        model.put("artifactId", "my-app");  // Puedes obtener este valor de otra fuente

        // Renderizar contenido del Dockerfile a partir de la plantilla Mustache
        String content = templateRenderer.render(GeneratorConstants.getDockerfileTemplate().toString(), model);
        Files.write(dockerFile, content.getBytes());
    }
}
