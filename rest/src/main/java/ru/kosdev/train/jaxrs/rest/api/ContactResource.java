package ru.kosdev.train.jaxrs.rest.api;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ru.kosdev.train.jaxrs.controller.dto.ContactDto;
import ru.kosdev.train.jaxrs.controller.dto.PageDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by kbryazgin on 5/12/2016.
 */
@Path("contacts")
@Api(value = "/contacts")
@Produces(MediaType.APPLICATION_JSON)
public interface ContactResource {

    @ApiOperation(
            value = "Create contact",
            notes = "\"groupList\" names will be ignored. \"id\" value in model is ignored"
        )
    @POST
    @Path("contact")
    @Consumes(MediaType.APPLICATION_JSON)
    ContactDto create(@Valid ContactDto contactDto);

    @ApiOperation(
            value = "Edit contact",
            notes = "\"groupList\" names will be ignored. \"id\" value in model is ignored"
        )
    @PUT
    @Path("contact/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    ContactDto update(@PathParam("id") Integer contactId, @Valid ContactDto contactDto);

    @ApiOperation(value = "Get contact")
    @GET
    @Path("contact/{id}")
    ContactDto getContact(@PathParam("id") Integer contactId);

    @ApiOperation(value = "Get contacts of group")
    @GET
    @Path("group/{groupId}")
    PageDto<ContactDto> getGroupContacts(@PathParam("groupId") Integer groupId,
                                         @NotNull(message = "page is null") @QueryParam("page") Integer page,
                                         @NotNull(message = "size is null") @QueryParam("size") Integer size);

    @ApiOperation(value = "Delete contact")
    @DELETE
    @Path("contact/{id}")
    void deleteContact(@PathParam("id") Integer contactId);

    @ApiOperation(value = "Get contacts")
    @GET
    PageDto<ContactDto> getContacts(@NotNull(message = "page is null") @QueryParam("page") Integer page,
                                    @NotNull(message = "size is null") @QueryParam("size") Integer size);
}
