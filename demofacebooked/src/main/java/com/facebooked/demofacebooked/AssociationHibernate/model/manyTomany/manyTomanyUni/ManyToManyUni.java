package com.facebooked.demofacebooked.AssociationHibernate.model.manyTomany.manyTomanyUni;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ManyToManyUni{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String employeeName;
    @ManyToMany(mappedBy = "employees",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ManyToManyBiOwner> addresses;
}
