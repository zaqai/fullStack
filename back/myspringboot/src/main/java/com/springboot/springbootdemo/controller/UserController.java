package com.springboot.springbootdemo.controller;


import com.springboot.springbootdemo.bean.User;
import com.springboot.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired

    private UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean addUser(@RequestBody User user) {
        System.out.println("新增数据：");
        return userService.addUser(user);
    }

    @CrossOrigin
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public boolean updateUser(@RequestBody User user) {
        System.out.println("更新数据：");
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public boolean delete(@RequestParam(value = "id", required = true) int Id) {
        System.out.println("删除数据：");
        return userService.deleteUser(Id);
    }


    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public User findByUserName(@RequestParam(value = "username", required = true) String username) {
        System.out.println("查询数据：");
        return userService.findUserByName(username);
    }

    @CrossOrigin
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<User> findByUserAge() {
        System.out.println("查询所有数据:");
        return userService.findAll();
    }


}