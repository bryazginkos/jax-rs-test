package ru.kosdev.train.jaxrs.service.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by kos on 07.05.16.
 */
public class AddressDto {

    @Getter
    @Setter
    @NotBlank(message = "address is blank")
    private String value;
}
