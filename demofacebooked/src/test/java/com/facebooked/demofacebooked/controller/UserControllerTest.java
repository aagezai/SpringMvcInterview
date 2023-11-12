package com.facebooked.demofacebooked.controller;

import com.facebooked.demofacebooked.model.User;
import com.facebooked.demofacebooked.pojo.SuccessResponse;
import com.facebooked.demofacebooked.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    @InjectMocks
    UserController userController;
    @Mock
    UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllUsers() {

    }

    @Test
    void findUsersByIds() {
        Long id = 121212L;
        User user = new User();
        user.setId(id);
        user.setName("name1");
        user.setSsn("12121");

        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setHttpStatusMessage(String.valueOf(HttpStatus.OK));
        successResponse.setHttpCode(HttpStatus.OK.value());
        successResponse.setData(user);
        successResponse.setErrorValidation(List.of());

        Mockito.when(userService.getUserById(id)).thenReturn(user);

        ResponseEntity<SuccessResponse> actualEntity = userController.getUserById(id);
        SuccessResponse actualSuccessResponse = actualEntity.getBody();
        User expectedUser = (User) successResponse.getData();
        User actualUser = (User) actualSuccessResponse.getData();
        assertEquals(expectedUser,actualUser);

    }

    @Test
    void getUserById() {
    }

    @Test
    void createUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}