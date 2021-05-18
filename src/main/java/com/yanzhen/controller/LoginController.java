package com.yanzhen.controller;


import com.yanzhen.entity.User;
import com.yanzhen.framework.jwt.JWTUtil;
import com.yanzhen.service.UserService;
import com.yanzhen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        User entity = userService.login(user.getUserName(), user.getPassword());
        if (entity !=null){
            String token = JWTUtil.sign(entity);
            Map map = new HashMap();
            map.put(JWTUtil.token,token);
            map.put("user",entity);
            return  Result.ok("登陆成功",map);
        }else{
            return  Result.fail("用户名或密码错误");
        }
    }
}
