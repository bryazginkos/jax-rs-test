package ru.kosdev.train.jaxrs.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by kbryazgin on 5/6/2016.
 */
@Path("/")
public class MainResource  {

    @GET
    @Path("res")
    public String get() {
        return "Hello world";
    }
}
