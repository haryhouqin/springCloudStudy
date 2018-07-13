package com.example.demo;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin2.message.GetNameSpaceMessage;

@SpringBootApplication
@EnableDiscoveryClient
public class DemoApplication {

   /* @Value("${foo}")
    String foo;

    @Value("${hi}")
    String hi;

    @RequestMapping(value = "/hi2")
    public String hi() {
        return hi;
    }

    @RequestMapping(value = "/hi3")
    public String hi3() {
        return foo;
    }
*/
   /* @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
        c.setIgnoreUnresolvablePlaceholders(true);
        return c;
    }

    @Value("${foo}")
    String foo;

    */

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    /*@Bean  //代码中手动配置route
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {

        return builder.routes()
                .route(
                        r -> r.path("/getAll")
                                .uri("http://localhost:8762")
                )
                .route(
                        r -> r.method("GET")
                                .uri(hi)
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
                                .uri(hi)
                )
                .build();
    }*/

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
