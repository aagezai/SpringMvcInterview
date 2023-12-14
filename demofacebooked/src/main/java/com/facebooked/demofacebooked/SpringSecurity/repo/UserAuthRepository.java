package com.facebooked.demofacebooked.SpringSecurity.repo;

import com.facebooked.demofacebooked.SpringSecurity.model.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, Integer> {

    UserAuth findByUsername(String username);
}
