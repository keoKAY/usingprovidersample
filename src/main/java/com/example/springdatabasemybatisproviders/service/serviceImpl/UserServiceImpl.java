package com.example.springdatabasemybatisproviders.service.serviceImpl;

import com.example.springdatabasemybatisproviders.model.User;
import com.example.springdatabasemybatisproviders.model.response.UserResponse;
import com.example.springdatabasemybatisproviders.repository.UserRepository;
import com.example.springdatabasemybatisproviders.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    // inject repo
    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public int insertNewUser(User user) {
        return userRepository.insertNewUserProvider(user);
    }

    @Override
    public int deleteUserByID(int id) {
        return userRepository.deleteUser(id);
    }

    @Override
    public int updateUser(User user) {
        return userRepository.updateUserInfo(user);
    }
}
