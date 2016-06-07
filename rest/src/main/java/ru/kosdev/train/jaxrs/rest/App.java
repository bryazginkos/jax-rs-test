package ru.kosdev.train.jaxrs.rest;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import ru.kosdev.train.jaxrs.rest.exceptions.BusinessExceptionMapper;
import ru.kosdev.train.jaxrs.rest.exceptions.ImageNotFoundExceptionMapper;
import ru.kosdev.train.jaxrs.rest.exceptions.IncorrectDataExceptionMapper;
import ru.kosdev.train.jaxrs.rest.exceptions.NotFoundExceptionMapper;
import ru.kosdev.train.jaxrs.rest.impl.ContactResourceImpl;
import ru.kosdev.train.jaxrs.rest.impl.GroupResourceImpl;
import ru.kosdev.train.jaxrs.rest.impl.ImageResourceImpl;

import javax.ws.rs.ApplicationPath;

/**
 * Created by kbryazgin on 5/6/2016.
 */
@ApplicationPath("api")
public class App extends ResourceConfig {

    public App() {
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);

        register(IncorrectDataExceptionMapper.class);
        register(NotFoundExceptionMapper.class);
        register(BusinessExceptionMapper.class);
        register(ImageNotFoundExceptionMapper.class);

        register(JacksonObjectMapperProvider.class);
        register(MultiPartFeature.class);
        register(JacksonFeature.class);

        register(ContactResourceImpl.class);
        register(ImageResourceImpl.class);
        register(GroupResourceImpl.class);

        register(ApiListingResource.class);
        register(SwaggerSerializers.class);

        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setBasePath("/api");
        beanConfig.setResourcePackage("ru.kosdev.train.jaxrs.rest");
        beanConfig.setScan(true);
        beanConfig.setPrettyPrint(true);
    }
}
