package io.spring.initializr.generator.spring.logback;

import org.springframework.context.annotation.Bean;

import io.spring.initializr.generator.io.template.MustacheTemplateRenderer;
import io.spring.initializr.generator.project.ProjectGenerationConfiguration;
import io.spring.initializr.generator.project.contributor.ProjectContributor;
import io.spring.initializr.generator.spring.devops.DevOpsProjectContributor;

@ProjectGenerationConfiguration
public class LogbackProjectConfiguration {

    @Bean
    public ProjectContributor logbackProjectContributor(MustacheTemplateRenderer templateRenderer) {
        return new LogbackProjectContributor(templateRenderer);
    }

}
