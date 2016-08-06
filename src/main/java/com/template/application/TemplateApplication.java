package com.template.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.template.application.configuration.TemplateConfiguration;
import com.template.application.factories.ResourceFactory;
import com.template.application.healthchecks.TemplateHealthcheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class TemplateApplication extends Application<TemplateConfiguration> {

    public static void main(String[] args) throws Exception {
        new TemplateApplication().run(args);
    }

    @Override
    public void run(TemplateConfiguration configuration, Environment environment) throws Exception {
        ObjectMapper objectMapper = configuration.objectMapper();

        environment.jersey().register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(objectMapper).to(ObjectMapper.class);
            }
        });

        // Register all resources with Jersey
        ResourceFactory resourceFactory = new ResourceFactory();
        environment.jersey().register(resourceFactory.templateResource());

        // Register health checks
        environment.healthChecks().register("template_healthcheck", new TemplateHealthcheck());
    }
}
