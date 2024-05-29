package com.chat.controller;

import com.chat.entity.po.User;
import com.chat.entity.properties.JwtProperties;
import com.chat.entity.vo.Result;
import com.chat.service.UserService;
import com.chat.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProperties jwtProperties;

    @GetMapping("/login")
    public Result<String> login( String username,String password) {
        log.info("username:{},password:{}", username, password);

        String token = userService.login(username, password);
        if(token==null || token.isEmpty()){
            return Result.error("登录失败");
        }
        return Result.success(token);
    }

    @PostMapping("/register")
    public Result<String> register(String username, String password) {
        log.info("username:{},password:{}", username, password);

        String token = userService.register(username, password);

        if(token==null || token.isEmpty()){
            return Result.error("注册失败");
        }
        return Result.success(token);

    }

    @GetMapping("/avater/{userId}")
    public Result<String> getAvater(@PathVariable String userId){

        return Result.success(userService.getAvater(userId));
    }
}
