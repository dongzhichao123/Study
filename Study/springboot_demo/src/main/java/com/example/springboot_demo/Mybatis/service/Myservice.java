package com.example.springboot_demo.Mybatis.service;

import com.example.springboot_demo.Mybatis.entity.User;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;


public interface Myservice {
    /*
    事务测试
     */
    public void delete(int id);

    public PageInfo<User> selectAllByPageInfo(Integer pageNum, Integer pageSize);
}
