package com.facebooked.demofacebooked.SpringSecurity.repo;

import com.facebooked.demofacebooked.SpringSecurity.model.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth,Long> {
    public Optional<UserAuth> findByEmail(String email);

}