package com.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class ChatRobotBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatRobotBackendApplication.class, args);
    }

}
