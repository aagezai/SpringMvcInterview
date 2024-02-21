package com.InterviewCompleteJavaSpring.AssociationHibernate.model.manyTomany.manyTomanyUni;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ManyToManyUniOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String addressName;

}
