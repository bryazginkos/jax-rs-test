package ru.kosdev.train.jaxrs.controller.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Created by kos on 07.05.16.
 */
public class GroupDto {

    private Integer id;

    @NotBlank(message = "{group.name.blank}")
    @Size(max = 20, message = "{group.name.long}")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
