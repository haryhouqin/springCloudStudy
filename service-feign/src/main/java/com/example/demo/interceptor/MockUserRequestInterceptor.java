package com.example.demo.interceptor;


import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author changyandong@e6yun.com
 * @Created Date: 2018/7/11 16:47
 * @ClassName MockUserRequestInterceptor
 * @Version: 1.0
 */
@Configuration
public class MockUserRequestInterceptor implements RequestInterceptor {
    static Logger logger = LoggerFactory.getLogger(MockUserRequestInterceptor.class);
    //@Value("${dev.defaultUserId:248}")
    int defaultUserId = 2;

    @Override
    public void apply(RequestTemplate template) {
        logger.debug(" -------------------------- in DemoInterceptor add userToken------------------------uid(dev.defaultUserId)={}",defaultUserId);
        template.header("uid",String.valueOf(defaultUserId));
    }
}
