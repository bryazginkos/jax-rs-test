package ru.kosdev.train.jaxrs.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.kosdev.train.jaxrs.service.api.contract.UserService;
import ru.kosdev.train.jaxrs.service.api.dto.ContactDto;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by kbryazgin on 5/6/2016.
 */
@Controller
public class ContactResourceImpl implements ContactResource {

    @Autowired
    private UserService userService;

    @Override
    public Response save(final ContactDto contactDto) {
        final ContactDto saved = userService.updateContact(contactDto);
        final boolean isNew = contactDto.getId() == null;
        return Response
                .status(isNew ? Response.Status.CREATED : Response.Status.ACCEPTED)
                .entity(saved)
                .build();
    }

    @Override
    public Response deleteContact(final Integer contactId) {
        userService.deleteContact(contactId);
        return Response.status(Response.Status.OK).build();
    }

    @Override
    public List<ContactDto> showContacts(final Integer page, final Integer size) {
        return userService.showContacts(page, size);
    }
}
