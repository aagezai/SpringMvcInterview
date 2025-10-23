package com.InterviewCompleteJavaSpring.AssociationHibernate.model.embedable;


import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class AddressEmbedableInPersonE implements Serializable {

    private String street;
    private String city;
    private String zipCode;

    // Constructors, getters, setters, etc.

    // Additional methods...
}
