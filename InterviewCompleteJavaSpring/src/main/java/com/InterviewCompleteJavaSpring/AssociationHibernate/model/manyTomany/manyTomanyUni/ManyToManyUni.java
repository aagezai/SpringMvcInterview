package com.InterviewCompleteJavaSpring.AssociationHibernate.model.manyTomany.manyTomanyUni;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ManyToManyUni{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String employeeName;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "manytoManyUniDir_addressId_employeeId",
            joinColumns =   @JoinColumn(name = "addressId"),
            inverseJoinColumns =      @JoinColumn(name = "employeeId")
    )
    @JsonIgnore
    private List<ManyToManyUniOwner> addresses;
}
