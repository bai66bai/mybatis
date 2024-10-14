package com.yang.mybatis.test;

import com.yang.mybatis.mapper.SelectMapper;
import com.yang.mybatis.pojo.User;
import com.yang.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;
import java.util.Map;

public class SelectMapperTest {

    /*
    * MyBatis的各种查询功能：
    * 1.若查询出的数据只有一条，可以通过实体类对象或者集合接收
    * 结果{password=123456, sex=男, id=3, age=23, email=12345@qq.com, username=猪猪侠}
    * 2.若是查询出的数据有多条，可以通过List集合来接收，一定不能通过实体类对象接收，此时会抛异常TooManyResultException
    *
    * 可以在mapper接口的方法上添加@MapKey注解，此时就可以将每条数据转换的map集合作为值，以某个字段的值作为建 然后放在同一个集合中
    * */
    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtil.sqlSessionUtils();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserById(5));
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.sqlSessionUtils();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(System.out::println);
    }

    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtil.sqlSessionUtils();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);
    }

    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtil.sqlSessionUtils();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserByIdToMap(3));
    }

    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtil.sqlSessionUtils();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        //List<Map<String, Object>> allUserToMap = mapper.getAllUserToMap();
        Map<String, Object> allUserToMap = mapper.getAllUserToMap();
        System.out.println(allUserToMap);
    }
}
