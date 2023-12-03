package com.facebooked.demofacebooked.AssociationHibernate.model.oneToMany;

import jakarta.persistence.*;

@Entity
@Table(name = "OneToManyUniOwner_address" )
public class OneToManyUniOwner {// address
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String addressName;


}
