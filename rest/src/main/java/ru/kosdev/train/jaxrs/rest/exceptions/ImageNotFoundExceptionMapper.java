package ru.kosdev.train.jaxrs.rest.exceptions;

import org.apache.commons.io.IOUtils;
import ru.kosdev.train.jaxrs.controller.api.ImageNotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.io.InputStream;


/**
 * Created by kos on 07.06.16.
 */
public class ImageNotFoundExceptionMapper implements ExceptionMapper<ImageNotFoundException> {
    @Override
    public Response toResponse(final ImageNotFoundException e) {
        try {
            final InputStream stream = getClass()
                    .getClassLoader()
                    .getResourceAsStream("no-image.jpg");

            final byte[] bytes = IOUtils.toByteArray(stream);
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(bytes)
                    .build();
        } catch (Exception configException) {
            throw new RuntimeException("Configuration error");
        }
    }
}
