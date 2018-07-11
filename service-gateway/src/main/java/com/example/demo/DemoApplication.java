package com.example.demo;

import com.example.demo.filter.CustomFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableDiscoveryClient
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
   /* @Bean  //代码中手动配置route
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {

        return builder.routes()
                .route(
                        r -> r.path("/getAll")
                                .uri("http://localhost:8762")
                )
                .route(
                        r -> r.method("GET")
                                .uri("http://baidu.com")
                )
                .route(
                        r -> r.method("POST")
                                .uri("https://github.com")
                )
                .route(
                        r -> r.path("/zh")
                                .uri("https://www.zhihu.com")
                )
                .route(
                        r -> r.path("/hi")
                                .uri("lb://service-hi")
                )
                .build();
    }
*/
  /* @Bean  //自定义过滤器 注入
   public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
       return builder.routes()
               .route(r -> r.path("/SERVICE-HI/**")
                       .filters(f -> f.stripPrefix(2)
                               .filter(new CustomFilter())
                               .addResponseHeader("X-Response-test", "test"))
                       .uri("lb://SERVICE-HI")
                       .order(0)
                       .id("test_consumer_service")
               )
               .build();
   }*/



}
