package com.facebooked.demofacebooked.AssociationHibernate.model.manyTomany.manyTomanyUni;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ManyToManyUniOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String addressName;
    @ManyToMany
    @JoinTable(
            name = "manytoMany_addressId_employeeId",
            joinColumns =   @JoinColumn(name = "addressId"),
             inverseJoinColumns =      @JoinColumn(name = "employeeId")
           )
    @JsonIgnore
    private List<ManyToManyUni> employees;
}
