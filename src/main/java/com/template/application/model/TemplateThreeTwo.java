package com.template.application.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TemplateThreeTwo extends TemplateThree {

    private String hello;

    @JsonCreator
    public TemplateThreeTwo(
            @JsonProperty("name") String name
    ) {
        super(name);
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    @Override
    public String toString() {
        return "TemplateThreeTwo";
    }
}
