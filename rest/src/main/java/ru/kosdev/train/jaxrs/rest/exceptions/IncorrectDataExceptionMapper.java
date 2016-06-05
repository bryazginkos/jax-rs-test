package ru.kosdev.train.jaxrs.rest.exceptions;

import ru.kosdev.train.jaxrs.controller.api.IncorrectDataException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by kbryazgin on 5/11/2016.
 */
@Provider
public class IncorrectDataExceptionMapper implements ExceptionMapper<IncorrectDataException> {
    @Override
    public Response toResponse(final IncorrectDataException e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(e.getMessage())
                .build();
    }
}
