package com.facebooked.demofacebooked.AssociationHibernate.model.compositeKey;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

    @EmbeddedId
    private BookId id;

    private String title;
    private String author;

    // Constructors, getters, setters, etc.

    // Additional methods...
}
