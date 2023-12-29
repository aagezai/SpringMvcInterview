package com.facebooked.demofacebooked.hibernateAndJpaController.repository.hibernateAndJpaRepository;

import com.facebooked.demofacebooked.hibernateAndJpaController.model.YourEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YourEntityJpaRepo extends JpaRepository<YourEntity,Long> {
}
