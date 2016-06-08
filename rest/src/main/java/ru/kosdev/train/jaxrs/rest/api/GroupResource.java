package ru.kosdev.train.jaxrs.rest.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ru.kosdev.train.jaxrs.controller.dto.GroupDto;
import ru.kosdev.train.jaxrs.controller.dto.PageDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by kos on 04.06.16.
 */
@Path("groups")
@Api(value = "/groups")
public interface GroupResource {

    @POST
    @Path("group")
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Create group",
            notes = "\"id\" value in model is ignored"
        )
    GroupDto create(@Valid GroupDto groupDto);

    @PUT
    @Path("group/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Edit group",
            notes = "\"id\" value in model is ignored"
        )
    GroupDto update(@PathParam("id") Integer groupId, @Valid GroupDto contactDto);

    @GET
    @Path("group/{id}")
    @ApiOperation(value = "Get group")
    GroupDto getGroup(@PathParam("id") Integer groupId);

    @DELETE
    @Path("group/{id}")
    @ApiOperation(value = "Delete group", notes = "Only group without members can be deleted")
    void deleteGroup(@PathParam("id") Integer groupId);

    @GET
    @ApiOperation(value = "Get groups")
    @Produces(MediaType.APPLICATION_JSON)
    PageDto<GroupDto> getGroups(@NotNull(message = "page is null") @QueryParam("page") Integer page,
                                     @NotNull(message = "size is null") @QueryParam("size") Integer size);

}
