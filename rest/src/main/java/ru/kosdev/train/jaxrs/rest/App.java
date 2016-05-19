package ru.kosdev.train.jaxrs.rest;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import ru.kosdev.train.jaxrs.rest.exceptions.ServiceExceptionMapper;

import javax.ws.rs.ApplicationPath;

/**
 * Created by kbryazgin on 5/6/2016.
 */
@ApplicationPath("api")
public class App extends ResourceConfig {

    public App() {
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        register(ServiceExceptionMapper.class);

        register(JacksonObjectMapperProvider.class);

        register(MultiPartFeature.class);
        register(ContactResourceImpl.class);
        register(ImageResourceImpl.class);
        register(JacksonFeature.class);
    }
}
