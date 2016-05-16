package ru.kosdev.train.jaxrs.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by kos on 07.05.16.
 */
@Embeddable
public class AdditionalInfo implements Serializable {

    @Getter @Setter
    private LocalDate dateValue;

    @Getter @Setter
    private String urlValue;

    @Getter @Setter
    private String textValue;

    @Getter @Setter
    private Integer intValue;

    @Getter @Setter
    private String emailValue;
}
