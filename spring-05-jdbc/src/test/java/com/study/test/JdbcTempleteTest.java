package com.study.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.study.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@ContextConfiguration("classpath:")
public class JdbcTempleteTest {
    @Test
    //测试spring产生jdbcTemplete对象
    public void test2() throws PropertyVetoException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplete");
        int row = jdbcTemplate.update("insert into student values (?,?,?,?)","6","赵刚","24","男");
        System.out.println(row);
    }
    @Test
    //测试jdbcTemplete开发步骤
    public void test() throws PropertyVetoException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/studyspring?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("root");
        jdbcTemplate.setDataSource(comboPooledDataSource);
        jdbcTemplate.update("insert into student values (?,?,?,?)","5","赵刚","24","男");
    }
}
