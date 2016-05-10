package ru.kosdev.train.jaxrs.rest;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by kbryazgin on 5/6/2016.
 */
@ApplicationPath("api")
public class App extends ResourceConfig {

    public App() {
        JacksonJaxbJsonProvider jsonProvider = new JacksonJaxbJsonProvider();
        jsonProvider.setMapper(new CustomObjectMapper());
        register(jsonProvider);

        register(MultiPartFeature.class);
        register(MainResource.class);
    }
}
