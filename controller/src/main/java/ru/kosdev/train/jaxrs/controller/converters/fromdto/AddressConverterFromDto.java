package ru.kosdev.train.jaxrs.controller.converters.fromdto;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.kosdev.train.jaxrs.controller.dto.AddressDto;
import ru.kosdev.train.jaxrs.repository.entity.Address;

import java.util.function.Function;


/**
 * Created by kos on 07.05.16.
 */
@Component
public class AddressConverterFromDto implements Function<AddressDto, Address> {
    @Override
    public Address apply(final AddressDto addressDto) {
        if (addressDto == null) {
            return null;
        }
        final Address address = new Address();
        address.setValue(addressDto.getValue());
        return address;
    }
}
