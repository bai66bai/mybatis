package com.yang.mybatis.mapper;

import com.yang.mybatis.pojo.User;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface UserMapper {

    /*
    * MyBatis面向接口编程的两个一致：
    * 1.映射文件的namespace要和mapper接口的类名保持一致
    * 2.映射文件中的SQL语句的id要和mapper接口中的方法名保持一致
    * */


    /*
      添加用户信息
     */
    int insertUser();

    /*
    * 修改用户信息
    * */
    void updateUser();


   //删除用户信息
    @Delete("delete from t_user where id = 4")
    void deleteUser();

    //根据id查询用户信息

    User getUserById();

    //查询所有的用户信息
    List<User> getAllUser();
}
