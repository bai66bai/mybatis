import com.yang.mybatis.mapper.EmpMapper;
import com.yang.mybatis.pojo.Emp;
import com.yang.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ResultMapTest {


    /*
    * 解决字段名和属性名不一致的情况：
    * a》为字段起别名，保持和属性名的一致
    * b》设置全局配置，将下划线_自动映射为小驼峰
    * <setting name="mapUnderscoreToCamelCase" value="true"/>
    *c>
    * */
    @Test
    public void testGetAllEmp(){
        SqlSession sqlSession = SqlSessionUtil.sqlSessionUtils();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.getAllEmp();
        list.forEach(System.out::println);
    }


    @Test
    public void testGetEmpAndDept(){
        SqlSession sqlSession;
        sqlSession = SqlSessionUtil.sqlSessionUtils();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDept(1);
        System.out.println(emp);
    }
}
