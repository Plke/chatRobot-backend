package com.chat.mapper;

import com.chat.entity.dto.MessageDTO;
import com.chat.entity.po.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {
    @Select("select content , user_id from message where chat_id=#{chatId}  order by create_time")
    List<Message> getByChatId(String chatId);

    @Insert("insert into message (content, user_id, chat_id,create_time) values (#{content}, #{userId}, #{chatId}, #{createTime})")
    void insert(MessageDTO messageDTO);
}
