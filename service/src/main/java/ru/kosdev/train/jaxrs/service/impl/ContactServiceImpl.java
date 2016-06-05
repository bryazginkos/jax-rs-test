package ru.kosdev.train.jaxrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.kosdev.train.jaxrs.service.api.ContactService;
import ru.kosdev.train.jaxrs.repository.dao.ContactRepository;
import ru.kosdev.train.jaxrs.repository.entity.Contact;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by Константин on 07.05.2016.
 */
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Nonnull
    @Override
    public Contact createContact(@Nonnull Contact contact) {
        contact.setId(null);
        return contactRepository.save(contact);
    }

    @Nonnull
    @Override
    public Contact updateContact(@Nonnull Integer contactId, @Nonnull Contact contact) {
        contact.setId(contactId);
        return contactRepository.save(contact);
    }

    @Nonnull
    @Override
    public Page<Contact> getContacts(@Nonnull Integer page, @Nonnull Integer pageSize) {
        return contactRepository.findAll(new PageRequest(page, pageSize));
    }

    @Nullable
    @Override
    public Contact getContact(@Nonnull Integer contactId) {
        return contactRepository.findOne(contactId);
    }

    @Override
    public boolean checkNameIsFree(@Nonnull String name) {
        final Contact sameNameContact = contactRepository.findByName(name);
        return sameNameContact == null;
    }

    @Override
    public boolean checkContactNameHasOnly(@Nonnull Integer contactId, @Nonnull String name) {
        final Contact sameNameContact = contactRepository.findByName(name);
        return sameNameContact == null || contactId.equals(sameNameContact.getId());
    }

    @Override
    public boolean exists(@Nonnull Integer contactId) {
        return getContact(contactId) != null;
    }

    @Override
    public void deleteContact(@Nonnull Integer contactId) {
        contactRepository.delete(contactId);
    }
}
