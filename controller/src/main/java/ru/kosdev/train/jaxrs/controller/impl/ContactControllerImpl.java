package ru.kosdev.train.jaxrs.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import ru.kosdev.train.jaxrs.controller.api.ContactController;
import ru.kosdev.train.jaxrs.controller.api.IncorrectDataException;
import ru.kosdev.train.jaxrs.controller.api.NotFoundException;
import ru.kosdev.train.jaxrs.controller.converters.fromdto.ContactConverterFromDto;
import ru.kosdev.train.jaxrs.controller.converters.todto.ContactConverterToDto;
import ru.kosdev.train.jaxrs.controller.converters.todto.PageConverterToDto;
import ru.kosdev.train.jaxrs.controller.dto.ContactDto;
import ru.kosdev.train.jaxrs.controller.dto.GroupDto;
import ru.kosdev.train.jaxrs.controller.dto.PageDto;
import ru.kosdev.train.jaxrs.repository.entity.Contact;
import ru.kosdev.train.jaxrs.service.api.ContactService;
import ru.kosdev.train.jaxrs.service.api.GroupService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kos on 04.06.16.
 */
@Controller
@Transactional
public class ContactControllerImpl implements ContactController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private ContactConverterToDto toDtoConverter;

    @Autowired
    private ContactConverterFromDto converterFromDto;

    @Autowired
    private PageConverterToDto pageConverterToDto;

    @Nonnull
    @Override
    public ContactDto createContact(@Nonnull ContactDto contactDto) {
        final boolean validName = contactService.checkNameIsFree(contactDto.getName());
        if (!validName) {
            throw new IncorrectDataException("The name " + contactDto.getName()
            + " is already used");
        }
        checkGroupsExist(contactDto.getGroupList());
        final Contact contact = converterFromDto.apply(contactDto);
        final Contact savedContact = contactService.createContact(contact);
        return toDtoConverter.apply(savedContact);
    }

    @Nonnull
    @Override
    public ContactDto updateContract(@Nonnull Integer id, @Nonnull ContactDto contactDto) {
        checkContactExists(id);
        final boolean validName = contactService.checkContactNameHasOnly(id, contactDto.getName());
        if (!validName) {
            throw new IncorrectDataException("The name " + contactDto.getName()
                    + " is already used");
        }
        checkGroupsExist(contactDto.getGroupList());
        final Contact contact = converterFromDto.apply(contactDto);
        final Contact updatedContract = contactService.updateContact(id, contact);
        return toDtoConverter.apply(updatedContract);
    }

    @Override
    public void deleteContact(@Nonnull Integer contactId) {
        checkContactExists(contactId);
        contactService.deleteContact(contactId);
    }

    @Nonnull
    @Override
    public PageDto<ContactDto> getContacts(@Nonnull Integer page, @Nonnull Integer pageSize) {
        final Page<Contact> contactPage = contactService.getContacts(page, pageSize);
        return pageConverterToDto.convert(contactPage, toDtoConverter);
    }

    @Override
    public PageDto<ContactDto> getContactsByGroupId(@Nonnull Integer groupId, @Nonnull Integer page, @Nonnull Integer pageSize) {
        if (!groupService.exists(groupId)) {
            throw new NotFoundException("The group with id " + groupId + " is not found");
        }
        final Page<Contact> contactPage = contactService.getContactsByGroupId(groupId, page, pageSize);
        return pageConverterToDto.convert(contactPage, toDtoConverter);
    }

    @Nonnull
    @Override
    public ContactDto getContact(@Nonnull Integer id) {
        checkContactExists(id);
        final Contact contact = contactService.getContact(id);
        return toDtoConverter.apply(contact);
    }

    private void checkGroupsExist(@Nullable List<GroupDto> groupList) {
        if (groupList != null) {
            final List<Integer> groupIdList = groupList.stream()
                    .map(GroupDto::getId)
                    .collect(Collectors.toList());
            for (Integer groupId : groupIdList) {
                if (!groupService.exists(groupId)) {
                    throw new IncorrectDataException("The group with id " + groupId + " doesn't exist");
                }
            }
        }
    }

    private void checkContactExists(@Nonnull Integer id) {
        if (!contactService.exists(id)) {
            throw new NotFoundException("The contact with id " + id + " doesn't exist");
        }
    }

}
