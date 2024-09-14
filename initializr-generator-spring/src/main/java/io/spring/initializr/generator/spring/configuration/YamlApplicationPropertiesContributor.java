package io.spring.initializr.generator.spring.configuration;
import io.spring.initializr.generator.project.contributor.ProjectContributor;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class YamlApplicationPropertiesContributor implements ProjectContributor {

    @Override
    public void contribute(Path projectRoot) throws IOException {
        // Definir las rutas
        Path resourceDir = projectRoot.resolve("src/main/resources");
        Path yamlFile = resourceDir.resolve("application.yml");
        Path propertiesFile = resourceDir.resolve("application.properties");

        // Crear el directorio resources si no existe
        if (!Files.exists(resourceDir)) {
            Files.createDirectories(resourceDir);
        }

        // Contenido YAML para application.yml
        String yamlContent = """
            server:
              port: 9002
            spring:
              application:
                name: demo-application
              profiles:
                active: dev
            logging:
              level:
                root: INFO
            """;

        // Escribir el contenido en application.yml
        Files.writeString(yamlFile, yamlContent);

        // Eliminar application.properties si existe
        if (Files.exists(propertiesFile)) {
            Files.delete(propertiesFile);
        }
    }
}
