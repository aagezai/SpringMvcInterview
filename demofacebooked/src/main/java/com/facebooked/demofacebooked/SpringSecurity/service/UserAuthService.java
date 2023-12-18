package com.facebooked.demofacebooked.SpringSecurity.service;

import com.facebooked.demofacebooked.SpringSecurity.model.UserAuth;
import com.facebooked.demofacebooked.SpringSecurity.repo.UserAuthRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAuthService {
    private final UserAuthRepository userAuthRepository;
    private final PasswordEncoder passwordEncoder;

    public UserAuthService(UserAuthRepository userAuthRepository, PasswordEncoder passwordEncoder) {
        this.userAuthRepository = userAuthRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserAuth saveUserAuth(UserAuth userAuth) {
        // You should encode the password before saving it
        System.out.println("in save user @@");
        userAuth.setPassword(passwordEncoder.encode(userAuth.getPassword()));
        return userAuthRepository.save(userAuth);
    }
    @PreAuthorize(value = "USER")
    public UserAuth deleteUserAuth(Long id) {
        System.out.println("delete UserAuth"+id);
        Optional<UserAuth> userAuth1 = userAuthRepository.findById(id);
        userAuthRepository.deleteById(id);
        return userAuth1.orElseThrow();
    }
}
