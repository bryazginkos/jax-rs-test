package ru.kosdev.train.jaxrs.rest.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kosdev.train.jaxrs.controller.api.IncorrectDataException;
import ru.kosdev.train.jaxrs.controller.dto.ErrorResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Created by kbryazgin on 5/11/2016.
 */
@Component
public class IncorrectDataExceptionMapper implements ExceptionMapper<IncorrectDataException> {

    @Autowired
    private Messages messages;

    @Override
    public Response toResponse(final IncorrectDataException e) {
        final String message = messages.getMessage(e);
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ErrorResponse(message))
                .build();
    }
}
