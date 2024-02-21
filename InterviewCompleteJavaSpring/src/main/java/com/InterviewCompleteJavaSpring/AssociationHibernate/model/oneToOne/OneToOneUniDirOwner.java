package com.InterviewCompleteJavaSpring.AssociationHibernate.model.oneToOne;

import jakarta.persistence.*;

@Entity
public class OneToOneUniDirOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "onToOneUniDir_id")
    private OneToONeUniDir oneToONeUniDir;

}
