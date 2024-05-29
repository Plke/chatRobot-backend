package com.chat.entity.po;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Message {
    private String chatId;
    private  String userId;
    private  String content;
    private LocalDateTime createTime;
}
