package com.InterviewCompleteJavaSpring.AssociationHibernate.model.embedable;


import jakarta.persistence.*;

@Entity
public class PersonE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    @Embedded
    private AddressEmbedableInPersonE address;

    // Constructors, getters, setters, etc.

    // Additional methods...
}
