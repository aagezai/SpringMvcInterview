package com.facebooked.demofacebooked.repository;

import com.facebooked.demofacebooked.pojo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
