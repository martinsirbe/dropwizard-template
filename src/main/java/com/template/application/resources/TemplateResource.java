package com.template.application.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.template.application.model.TemplateResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/template")
public class TemplateResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMethod(@QueryParam("name") String name, @Context ObjectMapper objectMapper) {
        TemplateResponse templateResponse;

        if (name == null) {
            templateResponse = new TemplateResponse("world");
        } else {
            templateResponse = new TemplateResponse(name);
        }
        return Response.ok(templateResponse).build();
    }
}