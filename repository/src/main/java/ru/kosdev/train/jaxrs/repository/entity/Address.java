package ru.kosdev.train.jaxrs.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
/**
 * Created by kos on 07.05.16.
 */
@Embeddable
public class Address {

    @Getter @Setter
    private String value;
}
