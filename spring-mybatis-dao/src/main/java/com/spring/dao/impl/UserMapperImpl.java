package com.spring.dao.impl;

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
 * @ClassName:UserDaoImpl
 * @Author Mr.guo
 * @Date 2021/4/14 21:18
 */
public class UserMapperImpl {//implements UserMapper {
  /*  @Override
    public List<User> findAll() throws IOException {
        SqlSession session = getSession();
        List<User> userList = session.selectList("userMapper.findAll");
        return userList;
    }

    public SqlSession getSession() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("MybatisMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }*/
}
