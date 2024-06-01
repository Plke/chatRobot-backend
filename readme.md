#  聊天机器人后端实现

基于spring boot + mybatis + mysql 实现

实现了登录注册，新建对话，对话功能

![页面](./readmeImg/1.png)


前端和模型接口实现如下：

[前端地址](https://github.com/Plke/chatRobot-front)
</br>
[机器人模型接口地址](https://github.com/Plke/chatRobot-model)

# 使用

## 修改本地资源位置
`src/main/java/com/chat/constant/Constants.java`中`LOCAL_FILE_PATH`
## 直接运行就行

## 机器人模型接口
`src/main/java/com/chat/service/impl/MessageServiceImpl.java`中`getNewMessage`中可以替换接口地址