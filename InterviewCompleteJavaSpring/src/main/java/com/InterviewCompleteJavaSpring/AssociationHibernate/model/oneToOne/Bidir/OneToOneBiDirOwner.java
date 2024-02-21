package com.InterviewCompleteJavaSpring.AssociationHibernate.model.oneToOne.Bidir;

import jakarta.persistence.*;

@Entity
public class OneToOneBiDirOwner {//Address
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long OneToOneBiDirOwnerId;
    private String OneToOneBiDirOwnerName;
    @OneToOne
    @JoinColumn(name = "oneToOneBiDir_id")
    private OneToOneBiDir oneToOneBiDir;//Employee
}
