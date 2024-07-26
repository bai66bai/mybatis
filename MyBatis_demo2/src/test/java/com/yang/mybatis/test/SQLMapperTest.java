package com.yang.mybatis.test;

import com.yang.mybatis.mapper.SQLMapper;
import com.yang.mybatis.pojo.User;
import com.yang.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SQLMapperTest {

    @Test
    public void TestGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtil.sqlSessionUtils();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> a = mapper.getUserByLike("a");
        a.forEach(System.out::println);
    }

    @Test
    public void TestDeleteMore(){
        SqlSession sqlSession = SqlSessionUtil.sqlSessionUtils();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        int result = mapper.deleteMore("1,2,3");
        System.out.println(result);
    }

    @Test
    public void TestGetTableName(){
        SqlSession sqlSession = SqlSessionUtil.sqlSessionUtils();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> tUser = mapper.getUserTableName("t_user");
        System.out.println(tUser);
    }

    @Test
    public void TestInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.sqlSessionUtils();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        User user = new User(null,"王五","123456",24,"男","123456@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
    }
}
