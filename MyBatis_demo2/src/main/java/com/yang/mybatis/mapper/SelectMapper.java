package com.yang.mybatis.mapper;

import com.yang.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {

//    根据ID查询用户信息
    User getUserById(Integer id);

//    查询所有用户信息
    List<User> getAllUser();
//    查询用户表中的总记录数
    Integer getCount();

//    根据Id查询用户信息作为一个map集合
    Map<String , Object> getUserByIdToMap(@Param("id") Integer id);

//    查询多个用户信息为map集合
    //List<Map<String , Object>> getAllUserToMap();
    @MapKey("id")
    Map<String , Object> getAllUserToMap();
}
