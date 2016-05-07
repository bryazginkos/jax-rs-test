package ru.kosdev.train.jaxrs.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.kosdev.train.jaxrs.service.api.contract.UserService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by kbryazgin on 5/6/2016.
 */
@Path("/")
@Controller
public class MainResource  {

    @Autowired
    private UserService userService;

    @GET
    @Path("res")
    public String get() {
        return "Hello world";
    }
}
