package com.yang.mybatis.mapper;

import com.yang.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SQLMapper {

//    根据用户名模糊查询用户值
    List<User> getUserByLike(@Param("username") String username);
//    批量删除
    int deleteMore(@Param("ids") String ids);

//    查询指定表中的数据
    List<User> getUserTableName(@Param("tableName") String tableName);

//    创建自增组件
    void insertUser(User user);
}
