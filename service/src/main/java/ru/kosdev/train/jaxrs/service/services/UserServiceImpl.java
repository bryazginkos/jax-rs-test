package ru.kosdev.train.jaxrs.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kosdev.train.jaxrs.api.UserService;
import ru.kosdev.train.jaxrs.dto.ContactDto;
import ru.kosdev.train.jaxrs.repository.dao.ContactRepository;
import ru.kosdev.train.jaxrs.repository.entity.Contact;

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

    @Override
    public void updateContact(ContactDto contactDto) {
        //// TODO: 07.05.16  
    }

    @Override
    public void deleteContact(Integer contactId) {
        //// TODO: 07.05.16  
    }

    @Override
    public List<ContactDto> showContacts(int start, int maxNumber) {
        //// TODO: 07.05.16  
        return null;
    }
}
