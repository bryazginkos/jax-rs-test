package ru.kosdev.train.jaxrs.rest;

import ru.kosdev.train.jaxrs.rest.exceptions.ServiceException;
import ru.kosdev.train.jaxrs.service.api.dto.ContactDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by kbryazgin on 5/12/2016.
 */
@Path("/")
public interface ContactResource {
    @POST
    @Path("contact")
    @Consumes(MediaType.APPLICATION_JSON)
    Response save(@Valid ContactDto contactDto) throws ServiceException;

    @DELETE
    @Path("contact/{id}")
    Response deleteContact(@PathParam(value = "id") Integer contactId);

    @GET
    @Path("contacts")
    @Produces(MediaType.APPLICATION_JSON)
    List<ContactDto> showContacts(@NotNull(message = "page is null") @QueryParam("page") Integer page,
                                  @NotNull(message = "size is null") @QueryParam("size") Integer size);
}
