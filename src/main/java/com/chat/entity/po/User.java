package com.chat.entity.po;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class User {
    private String userId;
    private String username;
    private String password;
    private LocalDateTime createTime;
}
