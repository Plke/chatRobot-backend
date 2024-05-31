package com.chat.service;

public interface UserService {

    String login(String username, String password);

    String register(String username, String password);

    String getAvatar(String name);
}
