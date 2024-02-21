package com.InterviewCompleteJavaSpring.hibernateAndJpaController.repository;

import com.InterviewCompleteJavaSpring.hibernateAndJpaController.pojo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
