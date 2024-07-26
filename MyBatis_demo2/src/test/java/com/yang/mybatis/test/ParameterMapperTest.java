package com.yang.mybatis.test;

import com.yang.mybatis.mapper.ParameterMapper;
import com.yang.mybatis.pojo.User;
import com.yang.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParameterMapperTest {

    /*
    * 获取参数值的两种方式：${}和 #{}
    * ${}本质是字符串拼接
    * #{}本质是占位符赋值
    * MyBatis获取参数值的各种情况
    * 1.mapper接口方法的参数为单个的字面量类型
    * 可以通过${}和 #{}以任意的名称获取参数值，但是需要注意${}的单引号问题
    * 2.mapper接口方法的参数可以为多个时
    * 此时MyBatis会将这些参数存放在一个map集合中，以两种方式进行存储
    * a》 以arg0，arg1.。。为键，以参数为值
    * b》 以param1，param2。。。为键，以参数为值
    * 因此只需要通过${}和 #{}以键的方式访问值即可，但是需要注意${}的单引号问题
    * 3.若mapper接口方法的参数有多个时，可以手动将这些参数放在一个map中存储
    * 只需要通过${}和 #{}以键的方式访问值即可，但是需要注意${}的单引号问题
    * 4.mapper接口方法的参数时实体类类型的参数
    *只需要通过${}和 #{}以属性的方式访问属性值即可，但是需要注意${}的单引号问题
    * 5.使用@param注解命名参数
    * 此时MyBatis会将这些参数存放在一个map集合中，以两种方式进行存储
    * a》 以arg0，arg1.。。为键，以参数为值
    * b》 以param1，param2。。。为键，以参数为值
    * 因此只需要通过${}和 #{}以键的方式访问值即可，但是需要注意${}的单引号问题
    * */

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.sqlSessionUtils();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(System.out::println);
    }
    @Test
    public void testGetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtil.sqlSessionUtils();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.getUserByUsername("猪猪侠");
        System.out.println(user);
    }
    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtil.sqlSessionUtils();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("猪猪侠","123456");
        System.out.println(user);
    }

    @Test
    public void testCheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtil.sqlSessionUtils();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username","猪猪侠");
        map.put("password","123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.sqlSessionUtils();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int i = mapper.insertUser(new User(null, "超人强", "123456", 23, "男", "12345@qq.com"));
        System.out.println(i);
    }

    @Test
    public void testCheckLoginByParam(){
        SqlSession sqlSession = SqlSessionUtil.sqlSessionUtils();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLoginByParam("猪猪侠","123456");
        System.out.println(user);
    }
}
