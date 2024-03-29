package com.InterviewCompleteJavaSpring.hibernateAndJpaController.service;

// UserService.java
import com.InterviewCompleteJavaSpring.hibernateAndJpaController.repository.UserRepository;
import com.InterviewCompleteJavaSpring.hibernateAndJpaController.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> findUsersByIds(List<Long> userIds) {
        return userRepository.findByIdIn(userIds);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User newUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setSsn(newUser.getSsn());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return userRepository.save(newUser);
                });
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
