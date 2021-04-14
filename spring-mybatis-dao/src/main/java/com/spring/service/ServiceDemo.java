package com.spring.service;

import com.spring.dao.UserMapper;
import com.spring.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName:ServiceDemo
 * @Author Mr.guo
 * @Date 2021/4/14 21:24
 */
public class ServiceDemo {

    public static void main(String[] args) throws IOException {
        {//使用代理映射动态实现
            SqlSession session = getSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            List<User> all = mapper.findAll();
            System.out.println(all);
            User user = mapper.findById(6);
            System.out.println(user);
            User user1 = new User();
            user1.setUsername("华会计aasdf师的话");
            user1.setPassword("123456");
            user1.setId(6);
            mapper.update(user1);

            session.commit();
        }

        /*{
            //创建dao层 测试手动创建
            UserMapper  userMapper = new UserMapperImpl();
            List<User> userList = userMapper.findAll();
            System.out.println(userList);
        }*/
    }

    public static SqlSession getSession() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("MybatisMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
}
