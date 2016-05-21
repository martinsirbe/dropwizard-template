package com.template.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Template {

    private String hello;

    public Template(String name) {
        this.hello = name;
    }

    public Template() {
        // An empty constructor is necessary for Jackson to parse input String to a POJO.
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
