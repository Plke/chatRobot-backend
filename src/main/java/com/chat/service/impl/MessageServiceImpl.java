package com.chat.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.chat.constant.Constants;
import com.chat.context.BaseContext;
import com.chat.entity.dto.ChatListDTO;
import com.chat.entity.dto.MessageDTO;
import com.chat.entity.po.Message;
import com.chat.entity.vo.MessageListVO;
import com.chat.mapper.ChatListMapper;
import com.chat.mapper.MessageMapper;
import com.chat.service.MessageServie;
import com.chat.utils.HttpClientUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageServie {

    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private ChatListMapper chatListMapper;

    @Override
    public MessageListVO getMessageListByChatId(String chatId) {
        List<Message> messageList = messageMapper.getByChatId(chatId);

        return MessageListVO.builder()
                .chatId(chatId)
                .messageList(messageList)
                .build();
    }

    @Override
    @Transactional
    public String getNewMessage(MessageDTO messageDTO) {
        messageDTO.setCreateTime(LocalDateTime.now());
        messageDTO.setUserId(BaseContext.getCurrentId());
        messageMapper.insert(messageDTO);
        ChatListDTO chatListDTO=ChatListDTO.builder()
                .chatId(messageDTO.getChatId())
                .updateTime(LocalDateTime.now())
                .build();
        chatListMapper.update(chatListDTO);

        String userContent = URLEncoder.encode(messageDTO.getContent(), StandardCharsets.UTF_8);
//        String res= HttpClientUtil.doGet("http://api.qingyunke.com/api.php?key=free&appid=0&msg="+userContent);
//        JSONObject jsonObject = JSONObject.parseObject(res);
//        String content = jsonObject.getString("content");

        String content= HttpClientUtil.doGet("http://127.0.0.1:5000/predict?input="+userContent);
        System.out.println("回复："+content);
        MessageDTO robot=MessageDTO.builder()
                .userId(Constants.ROBOT_ID)
                .content(content)
                .chatId(messageDTO.getChatId())
                .createTime(LocalDateTime.now())
                .build();
        messageMapper.insert(robot);

        return content;
    }
}
