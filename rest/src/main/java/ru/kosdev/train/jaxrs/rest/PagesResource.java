package ru.kosdev.train.jaxrs.rest;

import org.glassfish.jersey.server.mvc.Template;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by kos on 08.05.16.
 */
@Template
public class PagesResource {

    @GET
    @Path("/")
    public String index() {
        return "index";
    }
}
