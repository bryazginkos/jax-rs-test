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
    /**
     * Saves new contact if it doesn't have ID or else updates existing contact.
     * All groups in contact will be modified!
     * @param contactDto
     * @return
     * @throws ServiceException
     */
    @POST
    @Path("contact")
    @Consumes(MediaType.APPLICATION_JSON)
    Response save(@Valid ContactDto contactDto) throws ServiceException;

    /**
     * Deletes contact.
     * @param contactId
     * @return
     */
    @DELETE
    @Path("contact/{id}")
    Response deleteContact(@PathParam(value = "id") Integer contactId);

    /**
     * Show contacts.
     * @param page
     * @param size
     * @return
     */
    @GET
    @Path("contacts")
    @Produces(MediaType.APPLICATION_JSON)
    List<ContactDto> showContacts(@NotNull(message = "page is null") @QueryParam("page") Integer page,
                                  @NotNull(message = "size is null") @QueryParam("size") Integer size);
}
