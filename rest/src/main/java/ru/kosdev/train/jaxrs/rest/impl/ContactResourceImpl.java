package ru.kosdev.train.jaxrs.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.kosdev.train.jaxrs.controller.api.ContactController;
import ru.kosdev.train.jaxrs.controller.dto.ContactDto;
import ru.kosdev.train.jaxrs.controller.dto.PageDto;
import ru.kosdev.train.jaxrs.rest.api.ContactResource;

import javax.validation.constraints.NotNull;


/**
 * Created by kbryazgin on 5/6/2016.
 */
@Controller
public class ContactResourceImpl implements ContactResource {

    @Autowired
    private ContactController contactController;

    @Override
    public ContactDto create(ContactDto contactDto) {
        return contactController.createContact(contactDto);
    }

    @Override
    public ContactDto update(Integer contactId, ContactDto contactDto) {
        return contactController.updateContract(contactId, contactDto);
    }

    @Override
    public void deleteContact(Integer contactId) {
        contactController.deleteContact(contactId);
    }

    @Override
    public ContactDto getContact(Integer contactId) {
        return contactController.getContact(contactId);
    }

    @Override
    public PageDto<ContactDto> getContacts(Integer page, Integer size) {
        return contactController.getContacts(page, size);
    }

    @Override
    public PageDto<ContactDto> getGroupContacts(Integer groupId, @NotNull(message = "page is null") Integer page, @NotNull(message = "size is null") Integer size) {
        return contactController.getContactsByGroupId(groupId, page, size);
    }
}
