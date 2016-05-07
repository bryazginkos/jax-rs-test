package ru.kosdev.train.jaxrs.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by kos on 07.05.16.
 */
@Embeddable
public class AdditionalInfo {

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
