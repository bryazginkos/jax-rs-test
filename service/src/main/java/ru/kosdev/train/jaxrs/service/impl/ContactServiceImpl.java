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
    public Contact createContact(@Nonnull final Contact contact) {
        contact.setId(null);
        return contactRepository.save(contact);
    }

    @Nonnull
    @Override
    public Contact updateContact(@Nonnull final Integer contactId, @Nonnull final Contact contact) {
        contact.setId(contactId);
        return contactRepository.save(contact);
    }

    @Nonnull
    @Override
    public Page<Contact> getContacts(@Nonnull final Integer page, @Nonnull final Integer pageSize) {
        return contactRepository.findAll(new PageRequest(page, pageSize));
    }

    @Nonnull
    @Override
    public Page<Contact> getContactsByGroupId(@Nonnull final Integer groupId,
                                              @Nonnull final Integer page,
                                              @Nonnull final Integer pageSize) {
        return contactRepository.findByGroupListId(groupId, new PageRequest(page, pageSize));
    }

    @Nullable
    @Override
    public Contact getContact(@Nonnull final Integer contactId) {
        return contactRepository.findOne(contactId);
    }

    @Override
    public boolean checkNameIsFree(@Nonnull final String name) {
        final Contact sameNameContact = contactRepository.findByName(name);
        return sameNameContact == null;
    }

    @Override
    public boolean checkContactNameHasOnly(@Nonnull final Integer contactId, @Nonnull final String name) {
        final Contact sameNameContact = contactRepository.findByName(name);
        return sameNameContact == null || contactId.equals(sameNameContact.getId());
    }

    @Override
    public boolean exists(@Nonnull final Integer contactId) {
        return getContact(contactId) != null;
    }

    @Override
    public void deleteContact(@Nonnull final Integer contactId) {
        contactRepository.delete(contactId);
    }
}
