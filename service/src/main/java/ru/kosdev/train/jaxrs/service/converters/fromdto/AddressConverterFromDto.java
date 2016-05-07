package ru.kosdev.train.jaxrs.service.converters.fromdto;

import org.springframework.stereotype.Service;
import ru.kosdev.train.jaxrs.dto.AddressDto;
import ru.kosdev.train.jaxrs.repository.entity.Address;

import java.util.function.Function;

/**
 * Created by kos on 07.05.16.
 */
@Service
public class AddressConverterFromDto implements Function<AddressDto, Address> {
    @Override
    public Address apply(AddressDto addressDto) {
        if (addressDto == null) {
            return null;
        }
        Address address = new Address();
        address.setValue(addressDto.getValue());
        return address;
    }
}
