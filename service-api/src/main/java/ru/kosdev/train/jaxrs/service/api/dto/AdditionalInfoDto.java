package ru.kosdev.train.jaxrs.service.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Max;
import java.time.LocalDate;

/**
 * Created by kos on 07.05.16.
 */
public class AdditionalInfoDto {

    @Getter @Setter
    private LocalDate dateValue;

    @Getter @Setter
    private String urlValue;

    @Getter @Setter
    private String textValue;

    @Getter @Setter @Max(value = 100, message = "The int is bigger than 100")
    private Integer intValue;

    @Getter @Setter @Email(message = "email is invalid")
    private String emailValue;
}
