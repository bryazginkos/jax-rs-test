package ru.kosdev.train.jaxrs.service.converters.todto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kosdev.train.jaxrs.service.api.dto.AdditionalInfoDto;
import ru.kosdev.train.jaxrs.service.api.dto.AddressDto;
import ru.kosdev.train.jaxrs.service.api.dto.ContactDto;
import ru.kosdev.train.jaxrs.service.api.dto.GroupDto;
import ru.kosdev.train.jaxrs.repository.entity.AdditionalInfo;
import ru.kosdev.train.jaxrs.repository.entity.Address;
import ru.kosdev.train.jaxrs.repository.entity.Contact;
import ru.kosdev.train.jaxrs.repository.entity.Group;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by kos on 07.05.16.
 */
@Service
public class ContactConverterToDto implements Function<Contact, ContactDto> {

    @Autowired
    private Function<AdditionalInfo, AdditionalInfoDto> additionalInfoFunction;

    @Autowired
    private Function<Address, AddressDto> addressFunction;

    @Autowired
    private Function<Group, GroupDto> groupFunction;

    @Override
    public ContactDto apply(Contact contact) {
        if (contact == null) {
            return null;
        }
        ContactDto contactDto = new ContactDto();
        contactDto.setId(contact.getId());
        contactDto.setName(contact.getName());
        contactDto.setImageName(contact.getImageName());

        if (contact.getGroupList() != null) {
            List<GroupDto> groups = contact.getGroupList()
                    .stream()
                    .map(groupFunction)
                    .collect(Collectors.toList());
            contactDto.setGroupList(groups);
        }

        if (contact.getAdditionalInfoList() != null) {
            List<AdditionalInfoDto> additionalInfos = contact.getAdditionalInfoList()
                    .stream()
                    .map(additionalInfoFunction)
                    .collect(Collectors.toList());
            contactDto.setAdditionalInfoList(additionalInfos);
        }

        if (contact.getAddressList() != null) {
            List<AddressDto> addresses = contact.getAddressList()
                    .stream()
                    .map(addressFunction)
                    .collect(Collectors.toList());
            contactDto.setAddressList(addresses);
        }

        return contactDto;
    }
}
