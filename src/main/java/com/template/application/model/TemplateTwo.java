package com.template.application.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TemplateTwo {

    private String hello;

    @JsonCreator
    public TemplateTwo(
            @JsonProperty("name") String name
    ) {
        this.hello = name;
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    @Override
    public String toString() {
        return "TemplateTwo";
    }
}
