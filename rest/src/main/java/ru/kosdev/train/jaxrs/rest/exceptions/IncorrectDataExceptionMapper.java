package ru.kosdev.train.jaxrs.rest.exceptions;

import ru.kosdev.train.jaxrs.controller.api.IncorrectDataException;
import ru.kosdev.train.jaxrs.controller.dto.ErrorResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by kbryazgin on 5/11/2016.
 */
public class IncorrectDataExceptionMapper implements ExceptionMapper<IncorrectDataException> {
    @Override
    public Response toResponse(final IncorrectDataException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ErrorResponse(e.getMessage()))
                .build();
    }
}