package com.example.springdatabasemybatisproviders.service;

import com.example.springdatabasemybatisproviders.model.User;
import com.example.springdatabasemybatisproviders.model.response.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUsers();
    int insertNewUser(User user);
    int deleteUserByID(int id );

    int updateUser(User user);

}
