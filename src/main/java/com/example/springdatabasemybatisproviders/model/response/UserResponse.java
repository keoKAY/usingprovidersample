package com.example.springdatabasemybatisproviders.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private int id;
    private String username;
    private String gender;
    private String email;
    private String secretKey;
    private List<String> roles ;
}
