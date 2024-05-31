package com.chat.controller;

import com.chat.entity.dto.ChatListDTO;
import com.chat.entity.vo.ChatListVO;
import com.chat.entity.vo.MessageListVO;
import com.chat.entity.vo.Result;
import com.chat.service.ChatListService;
import com.chat.service.MessageServie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
public class ChatListController {

    @Autowired
    private ChatListService chatListService;

    @Autowired
    private MessageServie messageServie;

    /**
     * 获取该用户的对话列表
     *
     * @return
     */
    @GetMapping("/chatlist")
    public Result<List<ChatListVO>> getChatList() {
        log.info("getChatList");
        List<ChatListVO> chatList = chatListService.getChatList();
        return Result.success(chatList);
    }

    /**
     * 更具对话id删除对话
     *
     * @param chatId
     * @return
     */
    @DeleteMapping("/{chatId}")
    public Result<?> deleteChat(@PathVariable String chatId) {
        log.info("deleteChat: {}", chatId);
        chatListService.deleteByChatId(chatId);
        return Result.success();
    }

    /**
     * 创建新的对话
     *
     * @return
     */
    @PostMapping("/chatlist")
    public Result<String> addNewChat() {
        String chatId = chatListService.addNewChat();
        return Result.success(chatId);
    }

    /**
     * 更新对话名称
     *
     * @param chatListDTO
     * @return
     */
    @PutMapping("/{newName}")
    public Result<String> renameChat(@RequestBody ChatListDTO chatListDTO) {
        log.info("renameChat: {}", chatListDTO);
        chatListService.update(chatListDTO);
        return Result.success();
    }

    /**
     * 更具对话id，获取对话内容
     *
     * @param chatId
     * @return
     */
    @GetMapping("/{chatId}")
    public Result<MessageListVO> getMessageByChatId(@PathVariable String chatId) {
        log.info("获取对话内容，chatId: {}", chatId);
        MessageListVO messageListVO = messageServie.getMessageListByChatId(chatId);
        return Result.success(messageListVO);
    }
}
