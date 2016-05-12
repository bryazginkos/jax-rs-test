package ru.kosdev.train.jaxrs.rest;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.kosdev.train.jaxrs.rest.exceptions.ServiceException;
import ru.kosdev.train.jaxrs.rest.filemanager.FileManager;
import ru.kosdev.train.jaxrs.service.api.contract.UserService;
import ru.kosdev.train.jaxrs.service.api.dto.ContactDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.List;

/**
 * Created by kbryazgin on 5/6/2016.
 */
@Controller
@Path("/")
public class MainResource  {

    @Autowired
    private FileManager fileManager;

    @Autowired
    private UserService userService;

    @POST
    @Path("contact")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid final ContactDto contactDto) throws ServiceException {
        userService.updateContact(contactDto);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("contact/{id}")
    public Response deleteContact(@PathParam(value = "id") final Integer contactId) {
        userService.deleteContact(contactId);
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("contacts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ContactDto> showContacts(@NotNull(message = "page is null") @QueryParam("page") final Integer page,
                                         @NotNull(message = "size is null") @QueryParam("size") final Integer size) {
        return userService.showContacts(page, size);
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("upload")
    public Response uploadImage(@FormDataParam("file") final InputStream inputStream,
                              @FormDataParam("file") final FormDataContentDisposition fileMetaData) {
        final String imageName = fileManager.save(inputStream);
        return Response
                .status(Response.Status.OK)
                .entity(imageName)
                .build();
    }

    @GET
    @Path("image")
    @Produces("image/jpeg")
    public Response getFullImage(@NotBlank(message = "empty image name")
                                     @QueryParam("name") final String imageName) {
        final byte[] bytes = fileManager.get(imageName);
        return Response
                .ok(bytes)
                .build();
    }
}
