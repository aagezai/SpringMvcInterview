package com.facebooked.demofacebooked.hibernateAndJpaController.repository;

import com.facebooked.demofacebooked.hibernateAndJpaController.pojo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
