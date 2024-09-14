package io.spring.initializr.generator.spring.configuration;

import io.spring.initializr.generator.project.contributor.ProjectContributor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Component
public class CustomMainClassContributor implements ProjectContributor {
    @Override
    public void contribute(Path projectRoot) throws IOException {
        // Definir la ruta dinámica en función del proyecto generado
        Path sourcePath = projectRoot.resolve("src/main/java/com/example/demo/DemoApplication.java");

        // Si el archivo no existe, crear el directorio y el archivo
        if (!Files.exists(sourcePath)) {
            Files.createDirectories(sourcePath.getParent());
            Files.createFile(sourcePath);
        }

        // Modificar o escribir la clase principal
        String newContent = """
            package com.example.demo;
            
            import org.springframework.boot.SpringApplication;
            import org.springframework.boot.autoconfigure.SpringBootApplication;
            import org.springframework.context.annotation.Bean;

            @SpringBootApplication
            public class DemoApplication {

                public static void main(String[] args) {
                    SpringApplication.run(DemoApplication.class, args);
                }

                @Bean
                public String customBean() {
                    return "This is a custom bean!";
                }
            }
            """;

        // Sobrescribir la clase con el nuevo contenido
        Files.writeString(sourcePath, newContent, StandardOpenOption.TRUNCATE_EXISTING);
    }
}
