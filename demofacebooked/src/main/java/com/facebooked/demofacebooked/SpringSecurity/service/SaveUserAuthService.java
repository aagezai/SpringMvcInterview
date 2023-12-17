package com.facebooked.demofacebooked.SpringSecurity.service;

import com.facebooked.demofacebooked.SpringSecurity.model.UserAuth;
import com.facebooked.demofacebooked.SpringSecurity.repo.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SaveUserAuthService {
    private final UserAuthRepository userAuthRepository;
    private final PasswordEncoder passwordEncoder;

    public SaveUserAuthService(UserAuthRepository userAuthRepository, PasswordEncoder passwordEncoder) {
        this.userAuthRepository = userAuthRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserAuth saveUserAuth(UserAuth userAuth) {
        // You should encode the password before saving it
        System.out.println("in save user @@");
        userAuth.setPassword(passwordEncoder.encode(userAuth.getPassword()));
        return userAuthRepository.save(userAuth);
    }
}
