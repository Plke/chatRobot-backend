package com.chat.entity.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatList {
    private String chatId;
    private String chatName;
    private String userId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
