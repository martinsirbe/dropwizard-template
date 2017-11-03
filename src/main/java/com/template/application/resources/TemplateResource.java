package com.template.application.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.template.application.model.TemplateOne;
import com.template.application.model.TemplateThree;
import com.template.application.model.TemplateThreeOne;
import com.template.application.model.TemplateThreeTwo;
import com.template.application.model.TemplateTwo;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/template")
public class TemplateResource {

    private static final String DEFAULT_VALUE = "world";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMethod(@QueryParam("name") String name) {
        TemplateOne templateResponse;

        if (name != null) {
            templateResponse = new TemplateOne(name);
        } else {
            templateResponse = new TemplateOne(DEFAULT_VALUE);
        }
        return Response.ok(templateResponse).build();
    }

    @POST
    @Path("template/1")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postMethodOne(
            String input,
            @Context ObjectMapper objectMapper
    ) throws IOException {
        TemplateOne template = objectMapper.readValue(input, TemplateOne.class);

        TemplateOne templateResponse;
        if (template != null && template.getHello() != null) {
            templateResponse = new TemplateOne(template.getHello());
        } else {
            templateResponse = new TemplateOne(DEFAULT_VALUE);
        }
        return Response.status(Response.Status.CREATED).entity(templateResponse).build();
    }

    @POST
    @Path("template/2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postMethodTwo(
            TemplateTwo template,
            @Context ObjectMapper objectMapper
    ) throws IOException {
        TemplateTwo templateResponse;
        if (template != null && template.getHello() != null) {
            templateResponse = new TemplateTwo(template.getHello());
        } else {
            templateResponse = new TemplateTwo(DEFAULT_VALUE);
        }
        return Response.status(Response.Status.CREATED).entity(templateResponse).build();
    }

    @POST
    @Path("template/3")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postMethodThree(
            TemplateThree template,
            @Context ObjectMapper objectMapper
    ) throws IOException {
        TemplateThree templateResponse;

        if (template != null && template.getHello() != null) {
            templateResponse = new TemplateThree(template.getHello() + " " + template.toString());
        } else {
            templateResponse = new TemplateThree(DEFAULT_VALUE);
        }
        return Response.status(Response.Status.CREATED).entity(templateResponse).build();
    }

    @PUT
    public Response putMethod() {
        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }

    @DELETE
    public Response deleteMethod() {
        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }
}