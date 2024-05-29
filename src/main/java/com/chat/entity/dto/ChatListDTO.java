package com.chat.entity.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatListDTO {
    private String chatId;
    private String chatName;
    private LocalDateTime updateTime;
}
