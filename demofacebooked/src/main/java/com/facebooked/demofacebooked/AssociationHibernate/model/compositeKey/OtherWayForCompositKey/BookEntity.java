package com.facebooked.demofacebooked.AssociationHibernate.model.compositeKey.OtherWayForCompositKey;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookEntity")
@IdClass(CompositeKey.class)
public class BookEntity {

    @Id
    private String isbn;

    @Id
    private Long publisherId;

    private String title;
    private String author;

    // Constructors, getters, setters, etc.

    // Additional methods...
}
