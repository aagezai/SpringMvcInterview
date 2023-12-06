package com.facebooked.demofacebooked.AssociationHibernate.model.compositeKey;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class BookId implements Serializable {

    private String isbn;
    private Long publisherId;

    // Constructors, getters, setters, hashCode, equals, etc.
    
    // Make sure to implement equals and hashCode based on both fields
}
