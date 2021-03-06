package ru.kosdev.train.jaxrs.controller.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by kos on 07.05.16.
 */
public class ContactDto {

    private Integer id;

    @NotBlank(message = "{contact.name.blank}")
    @Size(max = 20, message = "{contact.name.long}")
    private String name;

    @Valid
    private List<GroupDto> groupList;

    @NotBlank(message = "{contact.image.name.blank}")
    @Size(max = 100, message = "{contact.image.name.long}")
    private String imageName;

    @Valid
    private List<AddressDto> addressList;

    @Valid
    private List<AdditionalInfoDto> additionalInfoList;

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

    public List<GroupDto> getGroupList() {
        return groupList;
    }

    public void setGroupList(final List<GroupDto> groupList) {
        this.groupList = groupList;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(final String imageName) {
        this.imageName = imageName;
    }

    public List<AddressDto> getAddressList() {
        return addressList;
    }

    public void setAddressList(final List<AddressDto> addressList) {
        this.addressList = addressList;
    }

    public List<AdditionalInfoDto> getAdditionalInfoList() {
        return additionalInfoList;
    }

    public void setAdditionalInfoList(final List<AdditionalInfoDto> additionalInfoList) {
        this.additionalInfoList = additionalInfoList;
    }
}
