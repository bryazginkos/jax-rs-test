package ru.kosdev.train.jaxrs.service.api.dto;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by kos on 07.05.16.
 */
public class GroupDto {

    private Integer id;

    @NotBlank(message = "group name is blank")
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
