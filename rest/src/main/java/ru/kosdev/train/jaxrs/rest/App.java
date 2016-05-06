package ru.kosdev.train.jaxrs.rest;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by kbryazgin on 5/6/2016.
 */
@ApplicationPath("/")
public class App extends ResourceConfig {

    public App() {
        packages("ru.kosdev.train.jaxrs.rest");
    }
}
