package com.facebooked.demofacebooked.SpringSecurity.controller;

import com.facebooked.demofacebooked.SpringSecurity.model.UserAuth;
import com.facebooked.demofacebooked.SpringSecurity.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userAuth")
public class ControllerUserAuth {

    private final UserAuthService userService;


    @Autowired
    public ControllerUserAuth(UserAuthService userService) {
        this.userService = userService;

    }

    @PostMapping("/save")
    public ResponseEntity<UserAuth> saveUser(@RequestBody UserAuth userAuth) {
        UserAuth savedUser = userService.saveUser(userAuth);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/public")
    public ResponseEntity<String> publicEndpoint() {
        return new ResponseEntity<>("Public Endpoint - No Authentication Required", HttpStatus.OK);
    }

    @GetMapping("/secure")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<String> secureEndpoint() {
        return new ResponseEntity<>("Secure Endpoint - Requires ROLE_USER", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserAuth>> getAllUsers() {
        List<UserAuth> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAuth> getUserById(@PathVariable Integer id) {
        UserAuth user = userService.getUserById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserAuth> getUserByUsername(@PathVariable String username) {
        UserAuth user = userService.getUserByUsername(username);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Add other controller methods as needed
}
