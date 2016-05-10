package ru.kosdev.train.jaxrs.rest;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import ru.kosdev.train.jaxrs.service.api.contract.UserService;
import ru.kosdev.train.jaxrs.service.api.dto.ContactDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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

    @PUT
    @Path("contact")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateContact(ContactDto contactDto) {

    }

    @POST
    @Path("contact")
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(ContactDto contactDto) {

    }


    @DELETE
    @Path("contact/{id}")
    public void deleteContact(@PathParam(value = "id") Integer contactId) {

    }

    @GET
    @Path("contacts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ContactDto> showContacts(@QueryParam("start") Integer start,
                                         @QueryParam("max") Integer max) {
        return null;
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
}
