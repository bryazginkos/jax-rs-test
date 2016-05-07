package ru.kosdev.train.jaxrs.service.converters.fromdto;

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
public class ContactConverterFromDto implements Function<ContactDto, Contact> {

    @Autowired
    private Function<AdditionalInfoDto, AdditionalInfo> additionalInfoFunction;

    @Autowired
    private Function<AddressDto, Address> addressFunction;

    @Autowired
    private Function<GroupDto, Group> groupFunction;

    @Override
    public Contact apply(ContactDto contactDto) {
        if (contactDto == null) {
            return null;
        }
        Contact contact = new Contact();
        contact.setId(contactDto.getId());
        contact.setName(contactDto.getName());
        contact.setImageName(contactDto.getImageName());

        if (contactDto.getGroupList() != null) {
            List<Group> groups = contactDto.getGroupList()
                    .stream()
                    .map(groupFunction)
                    .collect(Collectors.toList());
            contact.setGroupList(groups);
        }

        if (contactDto.getAdditionalInfoList() != null) {
            List<AdditionalInfo> additionalInfos = contactDto.getAdditionalInfoList()
                    .stream()
                    .map(additionalInfoFunction)
                    .collect(Collectors.toList());
            contact.setAdditionalInfoList(additionalInfos);
        }

        if (contactDto.getAddresses() != null) {
            List<Address> addresses = contactDto.getAddresses()
                    .stream()
                    .map(addressFunction)
                    .collect(Collectors.toList());
            contact.setAddresses(addresses);
        }

        return contact;
    }
}
