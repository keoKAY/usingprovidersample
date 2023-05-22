package com.example.springdatabasemybatisproviders.controller;


import com.example.springdatabasemybatisproviders.model.User;
import com.example.springdatabasemybatisproviders.model.response.UserResponse;
import com.example.springdatabasemybatisproviders.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserRestController {
    @Autowired
    UserService userService;

    @GetMapping("/all-users")
    public List<UserResponse> getAllUsers(){
        try{
            List<UserResponse> response = userService.getAllUsers();
            return response;
        }catch (Exception ex ){
            ex.printStackTrace();
            return  null;
        }
    }


    @PostMapping("/new-user")
    public User addNewUsers(@RequestBody User user){
        try{
            int affectedRow = userService.insertNewUser(user);
            System.out.println("Affected Row is : "+affectedRow);
            return  user;
        }catch (Exception ex ){
            ex.printStackTrace();
            return null;
        }
        // UserResponse


    }


    @DeleteMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable int id ){
        try {

            int affectedRow  = userService.deleteUserByID(id);
            System.out.println("Affected Row Delete : "+ affectedRow);
            return "Successfully Delete User ";
        }catch (Exception ex){
            ex.printStackTrace();
            return "Failed to delete ! ";
        }
    }


    @PatchMapping("/update-user/{id}")
    public String updateUser(@PathVariable int id,@RequestBody User user){
        try{
            user.setId(id); // get id from the path variables
            int affectedRow =    userService.updateUser(user);
            System.out.println("AffectedRow is : "+affectedRow);


            return "Successfully Update ";
        }catch (Exception ex){
             ex.printStackTrace();
             return "Failed to update user !";
        }

    }



}
