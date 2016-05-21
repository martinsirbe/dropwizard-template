package com.template.application.model;

public class TemplateResponse {

    private String hello;

    public TemplateResponse(String name) {
        this.hello = name;
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
