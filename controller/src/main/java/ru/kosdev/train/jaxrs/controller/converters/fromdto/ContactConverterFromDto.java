package ru.kosdev.train.jaxrs.controller.converters.fromdto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kosdev.train.jaxrs.controller.dto.ContactDto;
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
@Component
public class ContactConverterFromDto implements Function<ContactDto, Contact> {

    @Autowired
    private AdditionalInfoConverterFromDto additionalInfoFunction;

    @Autowired
    private AddressConverterFromDto addressFunction;

    @Autowired
    private GroupConverterFromDto groupFunction;

    @Override
    public Contact apply(final ContactDto contactDto) {
        if (contactDto == null) {
            return null;
        }
        final Contact contact = new Contact();
        contact.setId(contactDto.getId());
        contact.setName(contactDto.getName());
        contact.setImageName(contactDto.getImageName());

        if (contactDto.getGroupList() != null) {
            final List<Group> groups = contactDto.getGroupList()
                    .stream()
                    .map(groupFunction)
                    .collect(Collectors.toList());
            contact.setGroupList(groups);
        }

        if (contactDto.getAdditionalInfoList() != null) {
            final List<AdditionalInfo> additionalInfos = contactDto.getAdditionalInfoList()
                    .stream()
                    .map(additionalInfoFunction)
                    .collect(Collectors.toList());
            contact.setAdditionalInfoList(additionalInfos);
        }

        if (contactDto.getAddressList() != null) {
            final List<Address> addresses = contactDto.getAddressList()
                    .stream()
                    .map(addressFunction)
                    .collect(Collectors.toList());
            contact.setAddressList(addresses);
        }

        return contact;
    }
}
