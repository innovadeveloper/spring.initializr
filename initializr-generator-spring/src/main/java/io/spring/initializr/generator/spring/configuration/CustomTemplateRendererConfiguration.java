package io.spring.initializr.generator.spring.configuration;

import io.spring.initializr.generator.io.template.MustacheTemplateRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomTemplateRendererConfiguration {

    @Bean
    public MustacheTemplateRenderer mustacheTemplateRenderer() {
        // Assuming templates are located in "classpath:templates/"
        return new MustacheTemplateRenderer("classpath:templates/");
    }
}
