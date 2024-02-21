package com.InterviewCompleteJavaSpring.AssociationHibernate.model.oneToMany.Bidir;

import jakarta.persistence.*;

@Entity
@Table(name = "OneToManyBiDirOwnerAddress")
public class OneToManyBiDirOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String addressName;
    @ManyToOne
    @JoinColumn(name = "employee id")
    private OneToManyBiDir employeeBid;

}
