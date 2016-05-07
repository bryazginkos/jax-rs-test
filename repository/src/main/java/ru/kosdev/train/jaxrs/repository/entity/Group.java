package ru.kosdev.train.jaxrs.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by kos on 07.05.16.
 */
@Entity
@Table(name = "USER_GROUP")
public class Group {

    @Id
    @GeneratedValue
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private String name;
}
