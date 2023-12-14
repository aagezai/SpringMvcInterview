package com.facebooked.demofacebooked.SpringSecurity.pojo;

import com.facebooked.demofacebooked.SpringSecurity.model.UserAuth;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.List;

public class JwtGenerator {

    private static final String SECRET_KEY = "your-secret-key"; // Replace with your secret key

    public String generateToken(UserAuth userAuth) {
        // Set issued and expiration dates
        Date now = new Date();
        Date expiration = new Date(now.getTime() + 86400000); // Token valid for 1 day

        // Create the JWT with the payload directly in the claims
        String jwt = Jwts.builder()
                .setSubject(userAuth.getUserId())
                .claim("username", userAuth.getUsername())
                .claim("roles", userAuth.getRoles())
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();

        return jwt;
    }

    public static void main(String[] args) {
        // Example UserAuth with a List of roles
        UserAuth userAuth = new UserAuth();
        userAuth.setUserId("123");
        userAuth.setUsername("exampleUser");
        userAuth.setRoles(List.of("ROLE_USER", "ROLE_ADMIN"));

        // Generate JWT
        JwtGenerator jwtGenerator = new JwtGenerator();
        String jwt = jwtGenerator.generateToken(userAuth);

        // Display generated JWT
        System.out.println("Generated JWT: " + jwt);
    }
}
