package com.chat.service.impl;

import com.chat.constant.Constants;
import com.chat.entity.po.User;
import com.chat.entity.properties.JwtProperties;
import com.chat.entity.vo.Result;
import com.chat.mapper.UserMapper;
import com.chat.service.UserService;
import com.chat.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtProperties jwtProperties;

    @Override
    public String login(String username, String password) {

        User user = userMapper.login(username, password);
        if (user == null) {
            return "";
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getUserId());
        String token = JwtUtil.createJWT(jwtProperties.getUserSecretKey(), jwtProperties.getUserTtl(), claims);

        return token;
    }

    @Override
    public String register(String username, String password) {
        User user = userMapper.getUsername(username);
        if (user != null) {
            return "";
        }
        String uuid = UUID.randomUUID().toString();

        User newUser = User.builder()
                .userId(uuid)
                .username(username)
                .password(password)
                .createTime(LocalDateTime.now())
                .build();


        userMapper.insert(newUser);
        Map<String, Object> claims = new HashMap<>();

        claims.put("userID", newUser.getUserId());
        String token = JwtUtil.createJWT(jwtProperties.getUserSecretKey(), jwtProperties.getUserTtl(), claims);


        return token;
    }

    @Override
    public String getAvater(String userId) {
        String url=userMapper.getAvater(userId);
        if(url==null|| url.isEmpty()){
            url= Constants.DEFAULT_AVATER;
        }
        return url;
    }
}
