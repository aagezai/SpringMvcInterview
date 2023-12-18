package com.facebooked.demofacebooked.SpringSecurity.controller;

import com.facebooked.demofacebooked.SpringSecurity.model.UserAuth;
import com.facebooked.demofacebooked.SpringSecurity.pojo.request.LoginReq;
import com.facebooked.demofacebooked.SpringSecurity.pojo.response.ErrorRes;
import com.facebooked.demofacebooked.SpringSecurity.service.JwtUtil;
import com.facebooked.demofacebooked.SpringSecurity.service.UserAuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserAuthService saveUserAuthService;

    // Constructor injection
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserAuthService saveUserAuthService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.saveUserAuthService = saveUserAuthService;
    }

    // Existing methods...

   @PostMapping(value = "/saveUserAuth")
    public ResponseEntity saveUserAuth(@RequestBody UserAuth userAuth) {
        try {
            UserAuth savedUser = saveUserAuthService.saveUserAuth(userAuth);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            ErrorRes errorResponse = new ErrorRes(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
    @GetMapping(value = "/delete/{id}")
    public ResponseEntity deleteUserAuth(@PathVariable Long id) {
        try {
            System.out.println("delete UserAuth"+id);
            UserAuth savedUser = saveUserAuthService.deleteUserAuth(id);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            ErrorRes errorResponse = new ErrorRes(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
    @GetMapping(value = "/test")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("You are allowed here");
    }


   @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody LoginReq loginReq) {

        try {
            Authentication authentication;
            if (loginReq.getPassword().isEmpty()) {
                // JWT-based authentication
                authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginReq.getEmail(), "")
                );
            } else {
                // Traditional username/password authentication
                authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginReq.getEmail(), loginReq.getPassword())
                );
            }

            // Get UserDetails from Authentication principal
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            // Use userDetails or convert it to your UserAuth if needed
            UserAuth userAuth = convertUserDetailsToUserAuth(userDetails);

            String jwt = jwtUtil.createToken(userAuth);
            return ResponseEntity.ok(jwt);

        } catch (BadCredentialsException e) {
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, "Invalid username or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        } catch (Exception e) {
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    private UserAuth convertUserDetailsToUserAuth(UserDetails userDetails) {
        UserAuth userAuth = new UserAuth();
        userAuth.setEmail(userDetails.getUsername());
        userAuth.setPassword(userDetails.getPassword());
        return userAuth;
    }
}
