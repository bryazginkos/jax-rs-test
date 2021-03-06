package ru.kosdev.train.jaxrs.controller.converters.todto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kosdev.train.jaxrs.controller.dto.AdditionalInfoDto;
import ru.kosdev.train.jaxrs.controller.dto.AddressDto;
import ru.kosdev.train.jaxrs.controller.dto.ContactDto;
import ru.kosdev.train.jaxrs.controller.dto.GroupDto;
import ru.kosdev.train.jaxrs.repository.entity.Contact;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by kos on 07.05.16.
 */
@Component
public class ContactConverterToDto implements Function<Contact, ContactDto> {

    @Autowired
    private AdditionalInfoConverterToDto additionalInfoFunction;

    @Autowired
    private AddressConverterToDto addressFunction;

    @Autowired
    private GroupConverterToDto groupFunction;

    @Override
    public ContactDto apply(final Contact contact) {
        if (contact == null) {
            return null;
        }
        final ContactDto contactDto = new ContactDto();
        contactDto.setId(contact.getId());
        contactDto.setName(contact.getName());
        contactDto.setImageName(contact.getImageName());

        if (contact.getGroupList() != null) {
            final List<GroupDto> groups = contact.getGroupList()
                    .stream()
                    .map(groupFunction)
                    .collect(Collectors.toList());
            contactDto.setGroupList(groups);
        }

        if (contact.getAdditionalInfoList() != null) {
            final List<AdditionalInfoDto> additionalInfos = contact.getAdditionalInfoList()
                    .stream()
                    .map(additionalInfoFunction)
                    .collect(Collectors.toList());
            contactDto.setAdditionalInfoList(additionalInfos);
        }

        if (contact.getAddressList() != null) {
            final List<AddressDto> addresses = contact.getAddressList()
                    .stream()
                    .map(addressFunction)
                    .collect(Collectors.toList());
            contactDto.setAddressList(addresses);
        }

        return contactDto;
    }
}
