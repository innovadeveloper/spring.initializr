package io.spring.initializr.generator.spring.devops;

import org.springframework.context.annotation.Bean;

import io.spring.initializr.generator.io.template.MustacheTemplateRenderer;
import io.spring.initializr.generator.project.ProjectGenerationConfiguration;
import io.spring.initializr.generator.project.contributor.ProjectContributor;
import io.spring.initializr.generator.spring.container.docker.compose.DockerfileContributor;

@ProjectGenerationConfiguration
public class DevOpsProjectConfiguration {

    @Bean
    public ProjectContributor devOpsProjectContributor(MustacheTemplateRenderer templateRenderer) {
        return new DevOpsProjectContributor(templateRenderer);
    }

}
