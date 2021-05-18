package com.yanzhen.controller;


import com.github.pagehelper.PageInfo;
import com.yanzhen.entity.User;
import com.yanzhen.service.UserService;
import com.yanzhen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping("create")
    public  void create(){
        User user = new User();
        user.setUserName("熊大");
        user.setName("熊大");
        user.setPassword("666666");
        userService.create(user);
    }


    @GetMapping("delete")
    public  void  delete(Integer id){
     userService.delete(id);
    }

    @GetMapping("update")
    public  void update(User user){
        User user1 = new User();
        user.setUserName("熊二");
        user.setName("吉吉");
        user.setPassword("123123");
        user.setId(225);
        userService.update(user);
    }

    @GetMapping("detail")
    public  User detail(Integer id){
        return userService.detail(id);
    }


    @PostMapping("query")
    public Map<String,Object> query(@RequestBody User user){
        PageInfo<User> pageInfo = userService.query(user);
        return  Result.ok(pageInfo);
    }









}
