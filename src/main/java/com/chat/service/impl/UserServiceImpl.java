package com.chat.service.impl;

import com.chat.constant.Constants;
import com.chat.context.BaseContext;
import com.chat.entity.po.User;
import com.chat.entity.properties.JwtProperties;
import com.chat.mapper.UserMapper;
import com.chat.service.UserService;
import com.chat.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
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

        return JwtUtil.createJWT(jwtProperties.getUserSecretKey(), jwtProperties.getUserTtl(), claims);
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

        claims.put("userId", newUser.getUserId());


        return JwtUtil.createJWT(jwtProperties.getUserSecretKey(), jwtProperties.getUserTtl(), claims);
    }

    @Override
    public String getAvatar(String name) {
        if (name.equals("robot")) {
            return Constants.ROBOT_AVATAR;
        }
        String url = userMapper.getAvater(BaseContext.getCurrentId());
        if (url == null || url.isEmpty()) {
            url = Constants.DEFAULT_AVATAR;
        }
        return url;
    }
}
