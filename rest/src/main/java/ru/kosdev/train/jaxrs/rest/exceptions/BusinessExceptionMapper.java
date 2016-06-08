package ru.kosdev.train.jaxrs.rest.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kosdev.train.jaxrs.controller.api.BusinessException;
import ru.kosdev.train.jaxrs.controller.dto.ErrorResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Created by kos on 05.06.16.
 */
@Component
public class BusinessExceptionMapper implements ExceptionMapper<BusinessException> {

    @Autowired
    private Messages messages;

    @Override
    public Response toResponse(final BusinessException e) {
        final String message = messages.getMessage(e);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorResponse(message))
                .build();
    }
}
