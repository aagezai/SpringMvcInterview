package com.InterviewCompleteJavaSpring.hibernateAndJpaController.repository;

// UserRepository.java
import com.InterviewCompleteJavaSpring.hibernateAndJpaController.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
     List<User> findByIdIn(List<Long> userIds);
}

