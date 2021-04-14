package com.spring;

import com.spring.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName:Test
 * @Author Mr.guo
 * @Date 2021/4/13 21:15
 * 测试类
 */
public class MyBatisTest {

    @Test
    public void test4() throws IOException {
        SqlSession sqlSession = getSession();
        //执行操作 参数namespace.id
        sqlSession.insert("userMapper.delete",4);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test3() throws IOException {
        SqlSession sqlSession = getSession();
        //执行操作 参数namespace.id
        User user = new User();
        user.setId(4);
        user.setUsername("双开打哈接电话");
        user.setPassword("4564132");
        sqlSession.insert("userMapper.update",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        SqlSession sqlSession = getSession();
        //执行操作 参数namespace.id
        User user = new User();
        user.setUsername("华会计师的话");
        user.setPassword("asdasda");
        sqlSession.insert("userMapper.save",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test1() throws IOException {
        SqlSession sqlSession = getSession();
        //执行操作 参数namespace.id
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        System.out.println(userList);
        sqlSession.close();
    }

    @Test
    public void test5() throws IOException {
        SqlSession sqlSession = getSession();
        //执行操作 参数namespace.id
        User user = sqlSession.selectOne("userMapper.findById",2);
        System.out.println(user);
        sqlSession.close();
    }

    public SqlSession getSession() throws IOException {
        //获得核心控制文件
        InputStream resourceAsStream = Resources.getResourceAsStream("MyBatisMapperConfig.xml");
        //创建session工厂对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session对象
        SqlSession sqlSession = sessionFactory.openSession();
        return sqlSession;
    }
}
