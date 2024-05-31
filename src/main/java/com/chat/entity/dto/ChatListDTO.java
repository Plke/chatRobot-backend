package com.chat.entity.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ChatListDTO {
    private String chatId;
    private String chatName;
    private LocalDateTime updateTime;
}
