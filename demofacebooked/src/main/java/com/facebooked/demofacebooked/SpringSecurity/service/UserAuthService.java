package com.facebooked.demofacebooked.SpringSecurity.service;

import com.facebooked.demofacebooked.SpringSecurity.model.UserAuth;
import com.facebooked.demofacebooked.SpringSecurity.repo.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAuthService {

    private final UserAuthRepository userRepository;

    @Autowired
    public UserAuthService(UserAuthRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserAuth saveUser(UserAuth userAuth) {
        return userRepository.save(userAuth);
    }

    public List<UserAuth> getAllUsers() {
        return userRepository.findAll();
    }

    public UserAuth getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserAuth getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Add other service methods as needed
}
