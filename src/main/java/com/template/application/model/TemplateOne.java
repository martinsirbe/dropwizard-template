package com.template.application.model;

public class TemplateOne {

    private String hello;

    public TemplateOne(String name) {
        this.hello = name;
    }

    public TemplateOne() {
        // An empty constructor is necessary for Jackson to parse input String to a POJO.
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    @Override
    public String toString() {
        return "TemplateOne";
    }
}
