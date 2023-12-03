package com.facebooked.demofacebooked.AssociationHibernate.model.manyTomany.manyTomanyBi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ManyToManyBiOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String addressName;
    @ManyToMany
    @JoinTable(
            name = "manytoManyBid_addressId_employeeId",
            joinColumns =   @JoinColumn(name = "addressId"),
             inverseJoinColumns =      @JoinColumn(name = "employeeId")
           )
    @JsonIgnore
    private List<ManyToManyBi> employees;
}
