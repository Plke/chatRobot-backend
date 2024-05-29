package com.chat.entity.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChatListVO {
    private String chatId;
    private String chatName;
}
