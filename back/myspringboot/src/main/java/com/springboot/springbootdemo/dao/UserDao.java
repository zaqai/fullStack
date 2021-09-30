package com.springboot.springbootdemo.dao;

import com.springboot.springbootdemo.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Mapper
public interface UserDao {
    /**
     * 新增数据
     */
    @Insert("insert into user(id,username,password,email) values (#{id},#{username},#{password},#{email})")
    void addUser(User user);

    /**
     * 修改数据
     */
    @Update("update user set username=#{username},password=#{password},email=#{email} where id=#{id}")
    void updateUser(User user);

    /**
     * 删除数据
     */
    @Delete("delete from user where id=#{id}")
    void deleteUser(int id);

    /**
     * 根据查询数据
     *
     */
    @Select("select id,username,password,email from user where username=#{username}")
    User findByName(@Param("username") String username);

    /**
     * 查询所有数据
     */
    @Select("select id,username,password,email FROM user")
    List<User> findAll();

    /**
     * 用户登录
     */
    @Select("select * FROM user where username=#{username} and password={password}")
    boolean loginUser(String username,String password);


}
