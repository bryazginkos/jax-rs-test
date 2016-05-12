package ru.kosdev.train.jaxrs.rest;

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
@Path("/")
public interface ImageResource {

    /**
     * Upload image. Returns the unique key (imageName) for access.
     * @param inputStream
     * @param fileMetaData
     * @return
     */
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("image")
    Response uploadImage(@FormDataParam("file") InputStream inputStream,
                         @FormDataParam("file") FormDataContentDisposition fileMetaData);

    /**
     * Returns image by key.
     * @param imageName
     * @return
     */
    @GET
    @Produces("image/jpeg")
    @Path("image")
    Response loadImage(@NotBlank(message = "empty image name")
                          @QueryParam("name") String imageName);
}
