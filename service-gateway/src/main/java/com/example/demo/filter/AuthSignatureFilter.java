package com.example.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description  全局过滤器 在这里可以实现记录日志和访问权限校验等
 * @Author changyandong@e6yun.com
 * @Created Date: 2018/7/11 14:20
 * @ClassName AuthSignatureFilter
 * @Version: 1.0
 */
@Component
public class AuthSignatureFilter implements GlobalFilter, Ordered {

    static Logger logger = LoggerFactory.getLogger(AuthSignatureFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("request = {}",JSONArray.toJSONString( exchange.getRequest()) );
        String token = exchange.getRequest().getQueryParams().getFirst("authToken");
        //headers1.add("host","ddd");
      /*  ArrayList<String> strings = new ArrayList<>();
        strings.add("d");
        headers.add("host","888");*/
        ServerHttpRequest host = exchange.getRequest().mutate().header("a", "888").build();
        ServerWebExchange build = exchange.mutate().request(host).build();
        return chain.filter(build);
    }

    @Override
    public int getOrder() {
        return -200;
    }
}