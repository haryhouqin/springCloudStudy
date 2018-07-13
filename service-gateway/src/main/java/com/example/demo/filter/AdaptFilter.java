package com.example.demo.filter;

import org.springframework.cloud.gateway.filter.AdaptCachedBodyGlobalFilter;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author changyandong@e6yun.com
 * @Created Date: 2018/7/11 18:07
 * @ClassName AdaptFilter
 * @Version: 1.0
 */
@Configuration
public class AdaptFilter extends AdaptCachedBodyGlobalFilter {

    @Override
    public int getOrder() {
        return -222;
    }
}
