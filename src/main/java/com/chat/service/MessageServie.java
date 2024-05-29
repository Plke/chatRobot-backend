package com.chat.service;

import com.chat.entity.dto.MessageDTO;
import com.chat.entity.vo.MessageListVO;

public interface MessageServie {
    MessageListVO getMessageListByChatId(String chatId);

    String   getNewMessage(MessageDTO messageDTO);
}
