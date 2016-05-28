package com.template.application.resources;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.template.application.model.Template;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class TemplateResourceTest {

    private TemplateResource resource;
    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        resource = new TemplateResource();
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
    }

    @Test
    public void responseIsHelloWorldWhenNameParameterIsNull() throws Exception {
        Response response = resource.getMethod(null);
        assertThat(response.getStatus(), is(200));
        assertNotNull(response.getEntity());

        Template entity = (Template)response.getEntity();
        assertThat(entity.getHello(), is("world"));
    }

    @Test
    public void responseIsHelloFriendWhenNameParameterIsGiven() throws Exception {
        Response response = resource.getMethod("friend");
        assertThat(response.getStatus(), is(200));
        assertNotNull(response.getEntity());

        Template entity = (Template)response.getEntity();
        assertThat(entity.getHello(), is("friend"));
    }

    @Test
    public void responseIsHelloFriendWhenPostingHelloFriendJson() throws IOException {
        Response response = resource.postMethod("{\"hello\":\"friend\"}", objectMapper);
        assertThat(response.getStatus(), is(201));
        assertNotNull(response.getEntity());

        Template entity = (Template)response.getEntity();
        assertThat(entity.getHello(), is("friend"));
    }

    @Test
    public void responseIsHelloWorldWhenPostingWithoutJson() throws IOException {
        Response response = resource.postMethod("{}", objectMapper);
        assertThat(response.getStatus(), is(201));
        assertNotNull(response.getEntity());

        Template entity = (Template)response.getEntity();
        assertThat(entity.getHello(), is("world"));
    }

    @Test
    public void response501NotImplementedForPutMethod() {
        Response response = resource.putMethod();
        assertThat(response.getStatus(), is(501));
    }

    @Test
    public void response501NotImplementedForDeleteMethod() {
        Response response = resource.deleteMethod();
        assertThat(response.getStatus(), is(501));
    }
}