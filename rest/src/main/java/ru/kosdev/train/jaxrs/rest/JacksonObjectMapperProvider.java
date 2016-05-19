package ru.kosdev.train.jaxrs.rest;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.ext.ContextResolver;

/**
 * Created by kbryazgin on 5/19/2016.
 */
public class JacksonObjectMapperProvider implements ContextResolver<ObjectMapper> {

    private final ObjectMapper defaultObjectMapper;

    public JacksonObjectMapperProvider() {
        defaultObjectMapper =  createDefaultMapper();
    }

    private ObjectMapper createDefaultMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new LocalDateSerializationModule());
        return mapper;
    }

    @Override
    public ObjectMapper getContext(final Class<?> aClass) {
        return defaultObjectMapper;
    }
}
