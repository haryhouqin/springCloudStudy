package com.example.demo.service;

import com.example.demo.controller.HiController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 熔断返回正常服务
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Autowired
    private HiController hiController;
    @Override
    public String sayHiFromClientOne(String name) {

        return hiController.sayHi(name);
        //return "sorry" + name;
    }
}