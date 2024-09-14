package io.spring.initializr.generator.spring.container.docker.compose;

import org.springframework.context.annotation.Bean;

import io.spring.initializr.generator.io.template.MustacheTemplateRenderer;
import io.spring.initializr.generator.project.ProjectGenerationConfiguration;
import io.spring.initializr.generator.project.contributor.ProjectContributor;

@ProjectGenerationConfiguration
public class ComposeProjectConfiguration {

    @Bean
    public ProjectContributor dockerFileContributor(MustacheTemplateRenderer templateRenderer) {
        return new DockerfileContributor(templateRenderer);
    }

}
