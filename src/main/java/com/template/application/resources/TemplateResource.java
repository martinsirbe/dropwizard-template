package com.template.application.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.template.application.model.Template;

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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMethod(@QueryParam("name") String name) {
        Template templateResponse;

        if (name == null) {
            templateResponse = new Template("world");
        } else {
            templateResponse = new Template(name);
        }
        return Response.ok(templateResponse).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postMethod(String input, @Context ObjectMapper objectMapper) throws IOException {
        Template template = objectMapper.readValue(input, Template.class);

        Template templateResponse;
        if (template != null && template.getHello() != null) {
            templateResponse = new Template(template.getHello());
        } else {
            templateResponse = new Template("world");
        }
        return Response.status(201).entity(templateResponse).build();
    }

    @PUT
    public Response putMethod() {
        return Response.status(501).build();
    }

    @DELETE
    public Response deleteMethod() {
        return Response.status(501).build();
    }
}