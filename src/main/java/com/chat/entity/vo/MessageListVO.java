package com.chat.entity.vo;

import com.chat.entity.po.Message;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MessageListVO {
    private String  chatId;
    private List<Message> messageList;
}
