package ru.kosdev.train.jaxrs.service.api;


import org.springframework.data.domain.Page;
import ru.kosdev.train.jaxrs.repository.entity.Contact;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by Константин on 07.05.2016.
 */
public interface ContactService {

    @Nonnull
    Contact createContact(@Nonnull Contact contact);

    @Nonnull
    Contact updateContact(@Nonnull Integer contactId, @Nonnull Contact contact);

    @Nonnull
    Page<Contact> getContacts(@Nonnull Integer page, @Nonnull Integer pageSize);

    @Nullable
    Contact getContact(@Nonnull Integer contactId);

    boolean checkNameIsFree(@Nonnull String name);

    boolean checkContactNameHasOnly(@Nonnull Integer contactId, @Nonnull String name);

    boolean exists(@Nonnull Integer contactId);

    void deleteContact(@Nonnull Integer contactId);
}
