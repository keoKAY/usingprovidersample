package com.example.springdatabasemybatisproviders.repository.providers;

import com.example.springdatabasemybatisproviders.model.User;
import org.apache.ibatis.jdbc.SQL;

public class UserProvider {


    public static String getAllUsers(){
        return new SQL(){{
            // this style we can use if else ...
            SELECT("*");
            FROM("users_tb");
        }}.toString();
    }

    /*
    select  role from user_role_tb
                inner join role_tb rt
               on rt.id = user_role_tb.role_id
                where user_id =1 ;
    * */
    public static String getRolesByUserId(int id){
        return new SQL(){{
         SELECT("rt.role");
         FROM("user_role_tb");
         INNER_JOIN("role_tb rt on rt.id = user_role_tb.role_id");
         WHERE("user_id=#{id}");
        }}.toString();
    }

    public static String getAllUsers2(){
        return new SQL()
                .SELECT("*")
                .FROM("users_tb")
                .toString();
    }


    // iinsert new

    public static String insertNewUser(User user){
        return new SQL(){{
            INSERT_INTO("users_tb");
            VALUES("username","#{user.username}") ;
            VALUES("gender","#{user.gender}") ;
            VALUES("address","#{user.address}") ;
            VALUES("secret_key","#{user.secretKey}") ;
            VALUES("email","#{user.email}") ;
        }}.toString();
    }


    public static String deleteUserByID(int id ){
        return new SQL(){{
            DELETE_FROM("users_tb");
            WHERE("id=#{id}");
        }}.toString();
    }

    public static String updateUserByID(User user )
    {
        return new SQL(){{
            UPDATE("users_tb");
            SET("username=#{user.username}");
            SET("gender=#{user.gender}");
            SET("email=#{user.email}");
            SET("secret_key=#{user.secretKey}");
            SET("address=#{user.address}");
            WHERE("id=#{user.id}");
        }}.toString();
    }
}
