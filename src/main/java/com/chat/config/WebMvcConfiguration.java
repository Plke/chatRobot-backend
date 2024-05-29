package com.chat.config;

import com.chat.constant.Constants;
import com.chat.interceptor.JwtUserInterceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


import java.util.List;

/**
 * 配置类，注册web层相关组件
 */
@Configuration
@Slf4j
public class WebMvcConfiguration extends WebMvcConfigurationSupport {



    @Autowired
    private JwtUserInterceptor jwtUserInterceptor;
    /**
     * 注册自定义拦截器
     *
     * @param registry
     */
    protected void addInterceptors(InterceptorRegistry registry) {
        log.info("开始注册自定义拦截器...");
        registry.addInterceptor(jwtUserInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login");
    }

    /**
     * 设置静态资源映射
     *
     * @param registry
     */
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("开始注册静态资源映射");
        registry.addResourceHandler("/img/**").addResourceLocations("file:"+ Constants.LOCAL_FILE_PATH);//设置静态图片映射
    }

//    /**
//     * 扩展springMVC框架的消息转换器类
//     *
//     * @param converters
//     */
//    @Override
//    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        log.info("开始扩展消息转换器");
//        //创建一个消息转换器对象
//
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        //需要为消息转换器设置一个对象转换器，可以将java对象序列化为json数据
//        converter.setObjectMapper(new JacksonObjectMapper());
//        //将自己的消息转换器加入容器
//        converters.add(0, converter);
//    }
}
