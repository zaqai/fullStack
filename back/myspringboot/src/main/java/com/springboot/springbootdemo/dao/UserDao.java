package com.springboot.springbootdemo.dao;

import com.springboot.springbootdemo.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface UserDao {

    @Insert("insert into user(id,username,password,email) values (#{id},#{username},#{password},#{email})")
    void addUser(User user);

    @Update("update user set username=#{username},password=#{password},email=#{email} where id=#{id}")
    void updateUser(User user);

    @Delete("delete from user where id=#{id}")
    void deleteUser(int id);

    @Select("select id,username,password,email from user where username=#{username}")
    User findByName(@Param("username") String username);

    @Select("select id,username,password,email FROM user")
    List<User> findAll();

}
