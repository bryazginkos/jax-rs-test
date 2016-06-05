package ru.kosdev.train.jaxrs.controller.converters.todto;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.kosdev.train.jaxrs.controller.dto.AddressDto;
import ru.kosdev.train.jaxrs.repository.entity.Address;

import java.util.function.Function;

/**
 * Created by kos on 07.05.16.
 */
@Component
public class AddressConverterToDto implements Function<Address, AddressDto> {

    @Override
    public AddressDto apply(final Address address) {
        if (address == null) {
            return null;
        }
        final AddressDto addressDto = new AddressDto();
        addressDto.setValue(address.getValue());
        return addressDto;
    }
}
