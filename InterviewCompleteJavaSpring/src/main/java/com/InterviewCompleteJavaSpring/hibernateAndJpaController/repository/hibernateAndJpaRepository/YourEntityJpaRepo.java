package com.InterviewCompleteJavaSpring.hibernateAndJpaController.repository.hibernateAndJpaRepository;

import com.InterviewCompleteJavaSpring.hibernateAndJpaController.model.YourEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YourEntityJpaRepo extends JpaRepository<YourEntity,Long> {
}
