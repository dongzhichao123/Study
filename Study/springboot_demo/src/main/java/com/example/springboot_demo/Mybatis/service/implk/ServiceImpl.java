package com.example.springboot_demo.Mybatis.service.implk;

import com.example.springboot_demo.Mybatis.MyMybatis;
import com.example.springboot_demo.Mybatis.entity.User;
import com.example.springboot_demo.Mybatis.service.Myservice;
import com.example.springboot_demo.MybatisXml.UserXmlMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceImpl implements Myservice {

    @Autowired
    MyMybatis myMybatis;
   @Autowired
    UserXmlMapper userXmlMapper;
    @Override
    @Transactional
    public void delete(int id) {
        myMybatis.deleteUser(id);
        throw new RuntimeException("ceshi");
    }

    @Override
    public PageInfo<User> selectAllByPageInfo(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> userList=userXmlMapper.selectAll();
        PageInfo<User> userPageInfo=new PageInfo<>(userList);
        return userPageInfo;
    }
}
