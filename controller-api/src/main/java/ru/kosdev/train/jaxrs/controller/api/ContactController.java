package ru.kosdev.train.jaxrs.controller.api;

import ru.kosdev.train.jaxrs.controller.dto.ContactDto;
import ru.kosdev.train.jaxrs.controller.dto.PageDto;

import javax.annotation.Nonnull;

/**
 * Created by kos on 04.06.16.
 */
public interface ContactController {

    @Nonnull
    ContactDto createContact(@Nonnull ContactDto contactDto);

    @Nonnull
    ContactDto updateContract(@Nonnull Integer id, @Nonnull ContactDto contactDto);

    void deleteContact(@Nonnull Integer contactId);

    @Nonnull
    PageDto<ContactDto> getContacts(@Nonnull Integer page, @Nonnull Integer pageSize);

    @Nonnull
    ContactDto getContact(@Nonnull Integer id);
}
