package com.chat.entity.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MessageDTO {
    private String userId;
    private String content;
    private String chatId;
    private LocalDateTime createTime;
}
