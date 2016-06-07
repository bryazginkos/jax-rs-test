package ru.kosdev.train.jaxrs.rest.impl;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.kosdev.train.jaxrs.controller.api.ImageController;
import ru.kosdev.train.jaxrs.rest.api.ImageResource;

import javax.ws.rs.core.Response;
import java.io.InputStream;

/**
 * Created by kbryazgin on 5/12/2016.
 */
@Controller
public class ImageResourceImpl implements ImageResource {

    @Autowired
    private ImageController imageController;

    @Override
    public Response uploadImage(final InputStream inputStream) {
        final String imageName = imageController.save(inputStream);
        return Response
                .status(Response.Status.ACCEPTED)
                .entity(imageName)
                .build();
    }

    @Override
    public Response loadImage(final String imageName) {
        final byte[] bytes;
        bytes = imageController.get(imageName);
        return Response
                .ok(bytes)
                .build();
    }
}
