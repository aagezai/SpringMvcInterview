package com.facebooked.demofacebooked.SpringSecurity.controller;

import com.facebooked.demofacebooked.SpringSecurity.model.UserSecurity;
import com.facebooked.demofacebooked.SpringSecurity.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public")
public class PublicController {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @GetMapping
    public String publicEndpoint() {
        return "Public endpoint accessible to all";
    }
    @PostMapping("/save")
    public void saveUserSecurity(@RequestBody UserSecurity userSecurity) {
        System.out.println("user saved");
        customUserDetailsService.saveUserSecurity(userSecurity);
    }
}
