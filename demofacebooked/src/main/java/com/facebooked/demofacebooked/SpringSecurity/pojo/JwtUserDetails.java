package com.facebooked.demofacebooked.SpringSecurity.pojo;
import com.facebooked.demofacebooked.SpringSecurity.model.UserSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class JwtUserDetails implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private String name;

    // Constructors, getters, and other UserDetails methods

    public static JwtUserDetails createFromUser(UserSecurity user) {
        JwtUserDetails userDetails = new JwtUserDetails();
        userDetails.username = user.getUsername();
        userDetails.password = user.getPassword();
        userDetails.authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")); // Example role
        userDetails.name = user.getName();
        return userDetails;
    }

    public String getName() {
        return name;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Assuming accounts don't expire
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Assuming accounts are not locked
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Assuming credentials don't expire
    }

    @Override
    public boolean isEnabled() {
        return true; // Assuming accounts are enabled
    }
}
