package com.example.springboot_demo.Rest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springboot_demo.Mybatis.MyMybatis;
import com.example.springboot_demo.Mybatis.service.Myservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    MyMybatis myMybatis;
    @Autowired
    private Myservice myservice;

    @RequestMapping(value = "/one", method = RequestMethod.GET)
    public String getOne(@RequestParam("pageSize") Integer pageSize, @RequestParam("pageIndex") Integer pageIndex) {
//        System.out.println(key);
//        return myMybatis.getUserById(key).toString();
        return myMybatis.getAlluser(pageIndex.intValue(), pageSize.intValue()).toString();
    }

    @RequestMapping(value = "/two", method = RequestMethod.POST)
    public String getTwo(@RequestBody String params) {
        JSONObject jsonObject = JSON.parseObject(params);
        System.out.println(jsonObject);
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/three", method = RequestMethod.GET)
    public void delete(@RequestParam("id") Integer id) {
//        System.out.println(key);
//        return myMybatis.getUserById(key).toString();
        myservice.delete(id);
    }
}
