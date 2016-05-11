package ru.kosdev.train.jaxrs.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kosdev.train.jaxrs.repository.dao.GroupRepository;
import ru.kosdev.train.jaxrs.service.api.contract.UserService;
import ru.kosdev.train.jaxrs.service.api.dto.ContactDto;
import ru.kosdev.train.jaxrs.repository.dao.ContactRepository;
import ru.kosdev.train.jaxrs.repository.entity.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by Константин on 07.05.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Function<ContactDto, Contact> converterFromDto;

    @Autowired
    private Function<Contact, ContactDto> converterToDto;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Override
    @Transactional
    public void updateContact(ContactDto contactDto) {
        Contact contact = converterFromDto.apply(contactDto);
        if (contact.getGroupList() != null) {
            groupRepository.save(contact.getGroupList());
        }
        contactRepository.save(contact);
    }

    @Override
    @Transactional
    public void deleteContact(Integer contactId) {
        contactRepository.delete(contactId);
    }

    @Override
    @Transactional
    public List<ContactDto> showContacts(Integer start, Integer maxNumber) {
        Iterable<Contact> contacts = contactRepository.findAll();//// TODO: 5/10/2016  pages
        List<ContactDto> contactDtoList = new ArrayList<>();
        contacts.forEach(contact -> contactDtoList.add(converterToDto.apply(contact)));
        return contactDtoList;
    }
}
