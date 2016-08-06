package com.template.application.healthchecks;

import com.codahale.metrics.health.HealthCheck;
import com.template.application.resources.TemplateResource;

public class TemplateHealthcheck extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        // Some condition that checks application's health.
        return new TemplateResource().getMethod(null).getStatus() == 200
                ? Result.healthy()
                : Result.unhealthy("A wrong response code was returned.");
    }
}