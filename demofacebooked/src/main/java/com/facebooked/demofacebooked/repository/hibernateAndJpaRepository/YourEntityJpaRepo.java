package com.facebooked.demofacebooked.repository.hibernateAndJpaRepository;

import com.facebooked.demofacebooked.model.YourEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YourEntityJpaRepo extends JpaRepository<YourEntity,Long> {
}
