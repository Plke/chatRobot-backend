package com.chat.mapper;

import com.chat.entity.dto.ChatListDTO;
import com.chat.entity.po.ChatList;
import com.chat.entity.vo.ChatListVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ChatListMapper {
    @Select("select * from chat_list where user_id=#{userId} order by create_time desc")
    List<ChatListVO> listByUserId(String userId);

    @Delete("delete from chat_list where chat_id=#{chatId}")
    void deleteByChatId(String chatId);

    @Insert("insert into  chat_list (chat_id, chat_name,user_id,create_time,update_time) values (#{chatId}, #{chatName},#{userId},#{createTime},#{updateTime})")
    void insert(ChatList chatList);

    void update(ChatListDTO chatListDTO);
}
