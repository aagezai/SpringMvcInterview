package com.facebooked.demofacebooked.SpringSecurity.repo;

import com.facebooked.demofacebooked.SpringSecurity.model.UserAuth;
import org.springframework.stereotype.Repository;

@Repository
public class UserJwtRepository {
    public UserAuth findUserByEmail(String email){
        UserAuth user = new UserAuth(email,"123456");
        user.setFirstName("FirstName");
        user.setLastName("LastName");
        return user;
    }
}