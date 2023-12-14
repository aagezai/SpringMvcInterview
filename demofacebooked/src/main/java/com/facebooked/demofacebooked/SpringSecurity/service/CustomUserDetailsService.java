package com.facebooked.demofacebooked.SpringSecurity.service;

import com.facebooked.demofacebooked.SpringSecurity.model.UserSecurity;
import com.facebooked.demofacebooked.SpringSecurity.pojo.JwtUserDetails;
import com.facebooked.demofacebooked.SpringSecurity.repo.UserRepositorySecurity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepositorySecurity userRepository;

    public CustomUserDetailsService(UserRepositorySecurity userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Load user details from the database
        return userRepository.findByUsername(username)
                .map(JwtUserDetails::createFromUser)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }

    // Method to load user details from the database and match them with JWT claims
    public UserDetails loadUserFromJwt(String jwt) {
        // Extract claims from JWT
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSecretKey())
                .build()
                .parseClaimsJws(jwt)
                .getBody();

        // Load user details from the database using the username from claims
        UserDetails userDetailsFromDb = loadUserByUsername(claims.getSubject());

        // Perform additional checks or validations if needed
        // For example, compare additional fields like name
        if (userDetailsFromDb instanceof JwtUserDetails) {
            JwtUserDetails jwtUserDetailsFromDb = (JwtUserDetails) userDetailsFromDb;

            if (!jwtUserDetailsFromDb.getName().equals(claims.get("name"))) {
                // Additional validation failed
                throw new RuntimeException("JWT validation failed");
            }
        }

        return userDetailsFromDb;
    }

    // Helper method to get the secret key
    private SecretKey getSecretKey() {
        // Replace with your secret key logic
        return Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }
    public void saveUserSecurity(UserSecurity userSecurity){
        userRepository.save(userSecurity);
    }
}
