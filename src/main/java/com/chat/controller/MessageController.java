package com.chat.controller;

import com.chat.entity.dto.MessageDTO;
import com.chat.entity.vo.Result;
import com.chat.service.MessageServie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MessageController {
    @Autowired
    private MessageServie messageServie;

    @PostMapping("/chat")
    public Result<String> chat(@RequestBody MessageDTO messageDTO) {
        log.info("聊天,具体消息: {}", messageDTO);

        String newMessage = messageServie.getNewMessage(messageDTO);

        return Result.success(newMessage);
    }
}
