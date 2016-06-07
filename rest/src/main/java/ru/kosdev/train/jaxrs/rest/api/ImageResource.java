package ru.kosdev.train.jaxrs.rest.api;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.hibernate.validator.constraints.NotBlank;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;

/**
 * Created by kbryazgin on 5/12/2016.
 */
@Path("image")
public interface ImageResource {

    /**
     * Upload image. Returns the unique key (imageName) for access.
     * @param inputStream
     * @return
     */
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    Response uploadImage(@FormDataParam("file") InputStream inputStream);

    /**
     * Returns image by key.
     * @param imageName
     * @return
     */
    @GET
    @Produces("image/jpeg")
    Response loadImage(@NotBlank(message = "{image.name.empty}")
                          @QueryParam("name") String imageName);
}
