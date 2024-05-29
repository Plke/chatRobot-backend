package com.chat.service.impl;

import com.chat.context.BaseContext;
import com.chat.entity.dto.MessageDTO;
import com.chat.entity.po.Message;
import com.chat.entity.vo.MessageListVO;
import com.chat.mapper.MessageMapper;
import com.chat.service.MessageServie;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageServie {

    @Autowired
    private MessageMapper messageMapper;
    @Override
    public MessageListVO getMessageListByChatId(String chatId) {
        List<Message> messageList = messageMapper.getByChatId(chatId);

        return MessageListVO.builder()
                .chatId(chatId)
                .messageList(messageList)
                .build();
    }

    @Override
    public String getNewMessage(MessageDTO messageDTO) {
        messageDTO.setCreateTime(LocalDateTime.now());
        messageDTO.setUserId(BaseContext.getCurrentId());
        messageMapper.insert(messageDTO);

        String robotContent=RandomStringUtils.random(20, true, true);
        MessageDTO robot=MessageDTO.builder()
                .userId("robot")
                .content(robotContent)
                .chatId(messageDTO.getChatId())
                .createTime(LocalDateTime.now())
                .build();
        messageMapper.insert(messageDTO);

        return robotContent;
    }
}
