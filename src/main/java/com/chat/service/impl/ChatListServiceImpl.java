package com.chat.service.impl;

import com.chat.context.BaseContext;
import com.chat.entity.dto.ChatListDTO;
import com.chat.entity.po.ChatList;
import com.chat.entity.vo.ChatListVO;
import com.chat.mapper.ChatListMapper;
import com.chat.service.ChatListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ChatListServiceImpl implements ChatListService {

    @Autowired
    private ChatListMapper chatListMapper;

    @Override
    public List<ChatListVO> getChatList() {
        return chatListMapper.listByUserId(BaseContext.getCurrentId());
    }

    @Override
    public void deleteByChatId(String chatId) {
        chatListMapper.deleteByChatId(chatId);
    }

    @Override
    public String addNewChat() {
        ChatList chatList = new ChatList();
        String uuid = UUID.randomUUID().toString();
        chatList.setChatId(uuid);
        chatList.setChatName("新的对话");
        chatList.setUserId(BaseContext.getCurrentId());
        chatList.setCreateTime(LocalDateTime.now());
        chatList.setUpdateTime(LocalDateTime.now());
        chatListMapper.insert(chatList);
        return uuid;
    }

    @Override
    public void update(ChatListDTO chatListDTO) {
        chatListDTO.setUpdateTime(LocalDateTime.now());
        chatListMapper.update(chatListDTO);
    }
}
