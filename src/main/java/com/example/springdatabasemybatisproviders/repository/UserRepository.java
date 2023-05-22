package com.example.springdatabasemybatisproviders.repository;


import com.example.springdatabasemybatisproviders.model.User;
import com.example.springdatabasemybatisproviders.model.response.UserResponse;
import com.example.springdatabasemybatisproviders.repository.providers.UserProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


// insert , update , delete
@Repository
@Mapper
public interface UserRepository {
    @SelectProvider(type = UserProvider.class, method = "getAllUsers")
    @Results({
            @Result(property = "id" , column = "id"),
            @Result(property = "secretKey",column = "secret_key") ,
            @Result(property = "roles", column = "id",many = @Many(select = "findRolesByUserID"))
    })
    List<UserResponse> getAllUsers();
    @SelectProvider(type = UserProvider.class, method = "getRolesByUserId")
    List<String> findRolesByUserID(int id);



    // insert
    @Select("insert into users_tb ( username, gender, address, secret_key, email)\n" +
            "values (#{user.username},'male','svey reang','2342','testing@gmail.com') returning id")
    int insertNewUser(@Param("user") User user);

    // insert by using provider

    @InsertProvider(type = UserProvider.class, method = "insertNewUser")
    @Options(useGeneratedKeys = true,keyProperty = "user.id")
    int insertNewUserProvider(@Param("user") User user);


    @UpdateProvider(type = UserProvider.class, method = "updateUserByID")
    int updateUserInfo(@Param("user") User user );

    @DeleteProvider(type = UserProvider.class , method = "deleteUserByID")
    int deleteUser(int id );



}
