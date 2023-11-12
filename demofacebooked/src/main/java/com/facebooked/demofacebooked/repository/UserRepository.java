package com.facebooked.demofacebooked.repository;

// UserRepository.java
import com.facebooked.demofacebooked.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
     List<User> findByIdIn(List<Long> userIds);
}

