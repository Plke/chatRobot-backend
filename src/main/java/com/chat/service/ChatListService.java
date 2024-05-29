package com.chat.service;

import com.chat.entity.dto.ChatListDTO;
import com.chat.entity.vo.ChatListVO;

import java.util.List;

public interface ChatListService {
    List<ChatListVO> getChatList();

    void deleteByChatId(String chatid);

    String addNewChat();


    void update(ChatListDTO chatListDTO);
}
