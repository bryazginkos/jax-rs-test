package ru.kosdev.train.jaxrs.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kos on 07.05.16.
 */
@Entity
public class Contact {
    @Id
    @GeneratedValue
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @Getter @Setter
    private List<Group> groupList;

    @Getter @Setter
    private String imageName;

    @ElementCollection
    @Getter @Setter
    private List<Address> addresses;

    @ElementCollection
    @Getter @Setter
    private List<AdditionalInfo> additionalInfoList;
}