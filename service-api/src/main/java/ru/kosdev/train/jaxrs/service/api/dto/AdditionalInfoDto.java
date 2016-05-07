package ru.kosdev.train.jaxrs.service.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by kos on 07.05.16.
 */
public class AdditionalInfoDto {

    @Getter @Setter
    private Date dateValue;

    @Getter @Setter
    private String urlValue;

    @Getter @Setter
    private String textValue;

    @Getter @Setter
    private Integer intValue;

    @Getter @Setter
    private String emailValue;
}
