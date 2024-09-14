package io.spring.initializr.generator.spring.configuration;

import org.springframework.context.annotation.Bean;

import io.spring.initializr.generator.buildsystem.maven.MavenBuild;
import io.spring.initializr.generator.buildsystem.maven.MavenDependency;
import io.spring.initializr.generator.buildsystem.maven.MavenPlugin;
import io.spring.initializr.generator.project.ProjectGenerationConfiguration;
import io.spring.initializr.generator.spring.build.BuildCustomizer;
import io.spring.initializr.generator.version.VersionReference;

@ProjectGenerationConfiguration
public class CustomMavenBuildConfiguration {

    @Bean
    public BuildCustomizer<MavenBuild> customPropertiesCustomizer() {
        return build -> {
            // Agregar propiedades personalizadas en el nodo <properties> del pom.xml
            build.properties().property("java.version", "17");
            build.properties().property("project.build.sourceEncoding", "UTF-8");
            build.properties().property("project.reporting.outputEncoding", "UTF-8");
            build.properties().property("spring-boot.version", "3.1.10");
            build.properties().property("spring-cloud.version", "2022.0.4");

            build.plugins().add(
                    "org.springframework.boot",
                    "spring-boot-maven-plugin", plugin -> {
//                        plugin.version("3.1.0");
                        plugin.configuration(configuration -> {
                            configuration.add("exclude", exclude -> {
                                exclude.add("exclude", exclude2 -> {
                                    exclude2.add("groupId", "org.projectlombok");
                                    exclude2.add("artifactId", "lombok");
                                });
                            });
                        });
                    });
        };
    }

}
