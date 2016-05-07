package ru.kosdev.train.jaxrs.service.converters.todto;

import org.springframework.stereotype.Service;
import ru.kosdev.train.jaxrs.dto.AddressDto;
import ru.kosdev.train.jaxrs.repository.entity.Address;

import java.util.function.Function;

/**
 * Created by kos on 07.05.16.
 */
@Service
public class AddressConverterToDto implements Function<Address, AddressDto> {

    @Override
    public AddressDto apply(Address address) {
        if (address == null) {
            return null;
        }
        AddressDto addressDto = new AddressDto();
        addressDto.setValue(address.getValue());
        return addressDto;
    }
}
