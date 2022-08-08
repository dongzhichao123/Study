package com.example.springboot_demo.MybatisXml;

import com.example.springboot_demo.Mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserXmlMapper {
    public List<User> selectAll();

    public int addUser(User user);

    public User selectByName(@Param("username") String Name);

    public int updaterUser(User user);

    public int deleteUser(int id);
}
