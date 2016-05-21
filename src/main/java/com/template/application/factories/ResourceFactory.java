package com.template.application.factories;

import com.template.application.resources.TemplateResource;

public class ResourceFactory {

    private TemplateResource templateResource;

    public ResourceFactory() {
        templateResource = new TemplateResource();
    }

    public TemplateResource templateResource() {
        return templateResource;
    }
}
