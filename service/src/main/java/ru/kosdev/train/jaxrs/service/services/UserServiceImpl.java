package ru.kosdev.train.jaxrs.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kosdev.train.jaxrs.repository.dao.GroupRepository;
import ru.kosdev.train.jaxrs.service.api.contract.UserService;
import ru.kosdev.train.jaxrs.service.api.dto.ContactDto;
import ru.kosdev.train.jaxrs.repository.dao.ContactRepository;
import ru.kosdev.train.jaxrs.repository.entity.Contact;
import ru.kosdev.train.jaxrs.service.converters.fromdto.ContactConverterFromDto;
import ru.kosdev.train.jaxrs.service.converters.todto.ContactConverterToDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Константин on 07.05.2016.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private ContactConverterFromDto converterFromDto;

    @Autowired
    private ContactConverterToDto converterToDto;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public ContactDto updateContact(final ContactDto contactDto) {
        final Contact contact = converterFromDto.apply(contactDto);
        if (contact.getGroupList() != null) {
            groupRepository.save(contact.getGroupList());
        }
        Contact saved = contactRepository.save(contact);
        return converterToDto.apply(saved);
    }

    @Override
    public void deleteContact(final Integer contactId) {
        contactRepository.delete(contactId);
    }


    @Override
    public List<ContactDto> showContacts(final Integer page, final Integer pageSize) {
        final PageRequest pageRequest  = new PageRequest(page - 1, pageSize);
        final Iterable<Contact> contacts = contactRepository.findAll(pageRequest);

        final List<ContactDto> contactDtoList = new ArrayList<>();

        contacts.forEach(contact -> contactDtoList.add(converterToDto.apply(contact)));
        return contactDtoList;
    }
}
