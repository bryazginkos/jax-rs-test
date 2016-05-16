package ru.kosdev.train.jaxrs.repository.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by kos on 07.05.16.
 */
@Embeddable
public class Address implements Serializable {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }
}
