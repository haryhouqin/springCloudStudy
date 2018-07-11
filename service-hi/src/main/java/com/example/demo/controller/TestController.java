package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.demo.bean.Role;
import com.example.demo.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private RoleDao roleDao;

    @RequestMapping("/getAll")
    @ResponseBody
    private String get(){
        List<Role> all = roleDao.findAll();

        return JSONArray.toJSONString(all);
    }
}
