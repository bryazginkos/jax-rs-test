package ru.kosdev.train.jaxrs.service.api.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by kos on 07.05.16.
 */
public class GroupDto {
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private String name;
}
