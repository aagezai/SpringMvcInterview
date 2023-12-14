package com.facebooked.demofacebooked.SpringSecurity.repo;

import com.facebooked.demofacebooked.SpringSecurity.model.UserSecurity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepositorySecurity extends JpaRepository<UserSecurity, Long> {
    Optional<UserSecurity> findByUsername(String username);
}
