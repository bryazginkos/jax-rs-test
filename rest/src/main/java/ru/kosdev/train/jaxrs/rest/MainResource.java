package ru.kosdev.train.jaxrs.rest;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import ru.kosdev.train.jaxrs.service.api.contract.UserService;
import ru.kosdev.train.jaxrs.service.api.dto.ContactDto;

import javax.imageio.ImageIO;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

/**
 * Created by kbryazgin on 5/6/2016.
 */
@Controller
@Path("/")
public class MainResource  {

    @Value("${images.dir}")
    private String imagesPath;

    @Autowired
    private UserService userService;

    @POST
    @Path("contact")
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(@Valid ContactDto contactDto) throws ServiceException {
        userService.updateContact(contactDto);
    }

    @DELETE
    @Path("contact/{id}")
    public Response deleteContact(@NotBlank(message = "empty contact id")
                                      @PathParam(value = "id") Integer contactId) {
        userService.deleteContact(contactId);
        return Response.status(200).build();
    }

    @GET
    @Path("contacts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ContactDto> showContacts(@QueryParam("start") Integer start,
                                         @QueryParam("max") Integer max) {
        List<ContactDto> contactDtoList = userService.showContacts(start, max);
        return contactDtoList;
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("upload")
    public String uploadImage(@FormDataParam("file") InputStream inputStream,
                              @FormDataParam("file") FormDataContentDisposition fileMetaData) {
        UUID filename = UUID.randomUUID();
        try {
            Files.copy(inputStream, Paths.get(imagesPath + filename));
        } catch (IOException e) {
            throw new WebApplicationException("Error while uploading file. Please try again !!");
        }
        return filename.toString();
    }

    @GET
    @Path("image")
    @Produces("image/jpeg")
    public Response getFullImage(@NotBlank(message = "empty image name")
                                     @QueryParam("name") String imageName) throws IOException {

        BufferedImage image = ImageIO.read(new File(imagesPath + imageName));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpeg", baos);
        byte[] imageData = baos.toByteArray();
        return Response.ok(imageData).build();
    }
}
