package com.chat.entity.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
public class JwtProperties {

    private String userSecretKey = "planck";
    private long userTtl = 7200000;
    private String userTokenName = "token";

}
