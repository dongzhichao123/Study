package com.example.springboot_demo.Mybatis;

import com.example.springboot_demo.Mybatis.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MyMybatis {
    @Insert("INSERT INTO user(name, age) VALUES(#{name}, #{age})")
    int insertByUser(User user);

    @Select("select * from user limit #{pageIndex},#{pageSize}")
    public List<User> getAlluser(@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize);

    @Select("select * from user where id=#{id}")
    public User getUserById(@Param("id") int id);

    @Update("update user set Name=#{name},age=#{age} where id=#{id}")
    public int updateUser(User user);

    @Delete("DELETE FROM user WHERE ID = #{id}")
    public int deleteUser(@Param("id") int id);
}
