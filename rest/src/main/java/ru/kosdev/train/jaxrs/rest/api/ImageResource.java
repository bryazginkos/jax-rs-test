package ru.kosdev.train.jaxrs.rest.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.hibernate.validator.constraints.NotBlank;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;

/**
 * Created by kbryazgin on 5/12/2016.
 */
@Path("image")
@Api(value = "/image")
public interface ImageResource {

    /**
     * Upload image. Returns the unique key (imageName) for access.
     * @param inputStream
     * @return
     */
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @ApiOperation(value = "Upload image")
    String uploadImage(@FormDataParam("file") InputStream inputStream);

    /**
     * Returns image by key.
     * @param imageName
     * @return
     */
    @GET
    @Produces("image/jpeg")
    @ApiOperation(value = "Get image")
    byte[] loadImage(@NotBlank(message = "{image.name.empty}")
                          @QueryParam("name") String imageName);
}
