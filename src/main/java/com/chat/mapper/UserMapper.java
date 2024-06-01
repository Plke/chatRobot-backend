package com.chat.mapper;

import com.chat.entity.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where username = #{username} and password = #{password}")
    User login(String username, String password);

    @Select("select * from user where username = #{username}")
    User getUsername(String username);

    @Insert("insert into user(user_id, username, password, create_time) values (#{userId}, #{username}, #{password}, #{createTime})")
    void insert(User newUser);

    @Select("select avater from user where user_id=#{userId}")
    String getAvater(String userId);

    void update(User user);

}
