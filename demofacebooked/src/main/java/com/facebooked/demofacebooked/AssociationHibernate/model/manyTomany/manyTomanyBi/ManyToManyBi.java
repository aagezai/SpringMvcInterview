package com.facebooked.demofacebooked.AssociationHibernate.model.manyTomany.manyTomanyBi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ManyToManyBi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String employeeName;
    @ManyToMany(mappedBy = "employees",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ManyToManyBiOwner> addresses;
}
