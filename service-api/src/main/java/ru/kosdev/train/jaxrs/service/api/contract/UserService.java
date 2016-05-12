package ru.kosdev.train.jaxrs.service.api.contract;

import ru.kosdev.train.jaxrs.service.api.dto.ContactDto;

import java.util.List;

/**
 * Created by Константин on 07.05.2016.
 */
public interface UserService {

    void updateContact(ContactDto contactDto);

    void deleteContact(Integer contactId);

    List<ContactDto> showContacts(Integer page, Integer pageSize);
}
