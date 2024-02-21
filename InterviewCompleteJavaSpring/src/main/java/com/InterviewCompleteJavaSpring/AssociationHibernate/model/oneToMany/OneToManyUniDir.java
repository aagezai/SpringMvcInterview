package com.InterviewCompleteJavaSpring.AssociationHibernate.model.oneToMany;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "OneToManyUniDir_employee")
public class OneToManyUniDir {//Employee
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String employeeName;
    @OneToMany
    @JoinColumn(name = "employee_ids")
    private List<OneToManyUniOwner> addresses1;

}
