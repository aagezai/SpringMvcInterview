package com.InterviewCompleteJavaSpring.AssociationHibernate.model.oneToOne.Bidir;

import jakarta.persistence.*;

@Entity
public class OneToOneBiDir {//Employee
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long OneToOneBiDirId;
    private String OneToOneBiDirName;
    @OneToOne(mappedBy = "oneToOneBiDir",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})//Address is the owner of foreign key
    private OneToOneBiDirOwner oneToOneBiDirOwner;
}
