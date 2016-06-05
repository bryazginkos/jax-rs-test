package ru.kosdev.train.jaxrs.controller.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Created by kos on 07.05.16.
 */
public class AddressDto {

    @NotBlank(message = "address is blank")
    @Size(max = 20)
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }
}
