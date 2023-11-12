package com.facebooked.demofacebooked.controller;


import com.facebooked.demofacebooked.model.User;
import com.facebooked.demofacebooked.pojo.SuccessResponse;
import com.facebooked.demofacebooked.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SuccessResponse successResponse;

    @GetMapping
    public ResponseEntity<SuccessResponse> getAllUsers() {
        successResponse.setHttpCode(HttpStatus.OK.value());
        List<User> userList = userService.getAllUsers();
        successResponse.setData(userList);
        successResponse.setErrorValidation(List.of());
        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }

    @GetMapping("/findByIds")
    public List<User> findUsersByIds(@RequestParam List<Long> userIds) {
        return userService.findUsersByIds(userIds);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<SuccessResponse> getUserById(@PathVariable Long id) {
        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setHttpStatusMessage(String.valueOf(HttpStatus.OK));
        successResponse.setHttpCode(HttpStatus.OK.value());
        User user = userService.getUserById(id);
        successResponse.setData(user);
        successResponse.setErrorValidation(List.of());
        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User newUser) {
        return userService.updateUser(id, newUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
