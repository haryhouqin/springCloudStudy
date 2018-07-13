package com.example.demo;

import com.example.demo.interceptor.MockUserRequestInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
class DemoApplication {
    /*@Bean
    public MockUserRequestInterceptor getBean(){
        return new MockUserRequestInterceptor();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
