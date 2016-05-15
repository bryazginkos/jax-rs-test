package ru.kosdev.train.jaxrs.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by kos on 07.05.16.
 */
@Embeddable
public class Address implements Serializable {

    @Getter @Setter
    private String value;
}
