package com.springboot.springbootdemo.controller;

import com.springboot.springbootdemo.bean.User;
import com.springboot.springbootdemo.response.Result;
import com.springboot.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")

public class LoginController {
    @Autowired
    private UserService userService;
    @ApiOperation("登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody User user){
   /*     System.out.println(user.getUsername()+user.getPassword());
        if (user.getUsername() == null || user.getPassword() == null) {
            return JSON.toJSONString("账号密码不能为空");
        }
if(userService.loginUser(user.getUsername(),user.getPassword())){
    return JSON.toJSONString("dengluchengg");
}
return "unko";*/
        return JSON.toJSONString(new Result().setCode(500).setMessage("账号密码不能为空"));
    }
}
