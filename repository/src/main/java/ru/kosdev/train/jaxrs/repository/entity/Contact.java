package ru.kosdev.train.jaxrs.repository.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by kos on 07.05.16.
 */
@Entity
public class Contact implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Group> groupList;

    private String imageName;

    @ElementCollection
    private List<Address> addressList;

    @ElementCollection
    private List<AdditionalInfo> additionalInfoList;

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

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(final List<Group> groupList) {
        this.groupList = groupList;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(final String imageName) {
        this.imageName = imageName;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(final List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<AdditionalInfo> getAdditionalInfoList() {
        return additionalInfoList;
    }

    public void setAdditionalInfoList(final List<AdditionalInfo> additionalInfoList) {
        this.additionalInfoList = additionalInfoList;
    }
}
