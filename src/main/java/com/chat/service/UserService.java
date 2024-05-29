package com.chat.service;

import com.chat.entity.po.User;

public interface UserService {

    String login(String username, String password);

    String register(String username, String password);

    String getAvater(String userId);
}
