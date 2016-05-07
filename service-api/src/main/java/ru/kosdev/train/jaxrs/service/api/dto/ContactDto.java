package ru.kosdev.train.jaxrs.service.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by kos on 07.05.16.
 */
public class ContactDto {

    @Getter
    @Setter
    private Integer id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private List<GroupDto> groupList;

    @Getter @Setter
    private String imageName;

    @Getter @Setter
    private List<AddressDto> addresses;

    @Getter @Setter
    private List<AdditionalInfoDto> additionalInfoList;
}
