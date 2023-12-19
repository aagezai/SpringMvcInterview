package com.facebooked.demofacebooked.SpringSecurity.service;


import com.facebooked.demofacebooked.SpringSecurity.model.UserAuth;

import com.facebooked.demofacebooked.SpringSecurity.pojo.request.Role;
import com.facebooked.demofacebooked.SpringSecurity.repo.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserAuthRepository userAuthRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
      UserAuth user = userAuthRepository.findByEmail(email)
              .orElseThrow(() -> new UsernameNotFoundException("UserNotFound"));
        return new User(user.getEmail(), user.getPassword(), getAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority( role.name()))
                .collect(Collectors.toList());
    }
}