package com.InterviewCompleteJavaSpring.SpringSecurity.controller;

import com.InterviewCompleteJavaSpring.SpringSecurity.model.UserAuth;
import com.InterviewCompleteJavaSpring.SpringSecurity.pojo.request.LoginReq;
import com.InterviewCompleteJavaSpring.SpringSecurity.pojo.response.ErrorRes;
import com.InterviewCompleteJavaSpring.SpringSecurity.service.JwtUtil;
import com.InterviewCompleteJavaSpring.SpringSecurity.service.UserAuthService;
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
public class PublicController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserAuthService userAuthService;

    // Constructor injection
    public PublicController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserAuthService userAuthService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userAuthService = userAuthService;
    }

    // Existing methods...

   @PostMapping(value = "/saveUserAuth")
    public ResponseEntity signUpUser(@RequestBody UserAuth userAuth) {
        try {
            UserAuth savedUser = userAuthService.saveUserAuth(userAuth);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            ErrorRes errorResponse = new ErrorRes(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
    //@PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/delete/{id}")
    public ResponseEntity deactivateUser(@PathVariable Long id) {
        try {
            System.out.println("delete UserAuth"+id);
            UserAuth savedUser = userAuthService.deleteUserAuth(id);
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
            UserAuth userAuth = new UserAuth();
            userAuth.setEmail(userDetails.getUsername());
            userAuth.setPassword(userDetails.getPassword());
            // todo add roles
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


}
