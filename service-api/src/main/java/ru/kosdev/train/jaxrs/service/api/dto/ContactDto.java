package ru.kosdev.train.jaxrs.service.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by kos on 07.05.16.
 */
public class ContactDto {

    @Getter
    @Setter
    private Integer id;

    @Getter @Setter @NotBlank(message = "contact name is blank")
    private String name;

    @Getter @Setter @Valid
    private List<GroupDto> groupList;

    @Getter @Setter @NotBlank(message = "image name is blank")
    private String imageName;

    @Getter @Setter @Valid
    private List<AddressDto> addressList;

    @Getter @Setter @Valid
    private List<AdditionalInfoDto> additionalInfoList;
}
