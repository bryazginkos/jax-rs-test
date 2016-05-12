package ru.kosdev.train.jaxrs.rest;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.kosdev.train.jaxrs.rest.filemanager.FileManager;

import javax.ws.rs.core.Response;
import java.io.InputStream;

/**
 * Created by kbryazgin on 5/12/2016.
 */
@Controller
public class ImageResourceImpl implements ImageResource {

    @Autowired
    private FileManager fileManager;

    @Override
    public Response uploadImage(final InputStream inputStream,
                                final FormDataContentDisposition fileMetaData) {
        final String imageName = fileManager.save(inputStream);
        return Response
                .status(Response.Status.ACCEPTED)
                .entity(imageName)
                .build();
    }

    @Override
    public Response loadImage(final String imageName) {
        final byte[] bytes = fileManager.get(imageName);
        return Response
                .ok(bytes)
                .build();
    }
}
