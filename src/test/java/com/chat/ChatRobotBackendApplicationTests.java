package com.chat;

import com.alibaba.fastjson.JSONObject;
import com.chat.utils.HttpClientUtil;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

//@SpringBootTest
class ChatRobotBackendApplicationTests {

    @Test
    void contextLoads() throws UnsupportedEncodingException {
        String str = URLEncoder.encode("你好", StandardCharsets.UTF_8);
        String robotContent = HttpClientUtil.doGet("http://api.qingyunke.com/api.php?key=free&appid=0&msg=" + str);

        JSONObject jsonObject = JSONObject.parseObject(robotContent);
        String content = jsonObject.getString("content");
        System.out.println(content);

    }


}
