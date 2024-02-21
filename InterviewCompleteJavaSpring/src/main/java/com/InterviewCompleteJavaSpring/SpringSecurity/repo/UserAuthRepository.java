package com.InterviewCompleteJavaSpring.SpringSecurity.repo;

import com.InterviewCompleteJavaSpring.SpringSecurity.model.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth,Long> {
    public Optional<UserAuth> findByEmail(String email);

}