package com.chat.controller;

import com.chat.entity.properties.JwtProperties;
import com.chat.entity.vo.Result;
import com.chat.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProperties jwtProperties;

    @GetMapping("/login")
    public Result<String> login(String username, String password) {
        log.info("username:{},password:{}", username, password);

        String token = userService.login(username, password);
        if (token == null || token.isEmpty()) {
            return Result.error("登录失败");
        }
        return Result.success(token);
    }

    @PostMapping("/register")
    public Result<String> register(String username, String password) {
        log.info("username:{},password:{}", username, password);

        String token = userService.register(username, password);

        if (token == null || token.isEmpty()) {
            return Result.error("注册失败");
        }
        return Result.success(token);

    }

    @GetMapping("/avatar/{name}")
    public Result<String> getUserAvatar(@PathVariable String name) {
        log.info("获取头像:{}", name);
        return Result.success(userService.getAvatar(name));
    }

}
