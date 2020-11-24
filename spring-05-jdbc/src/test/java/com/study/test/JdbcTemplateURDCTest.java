package com.study.test;

import com.study.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateURDCTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void testUpdate(){
        int row = jdbcTemplate.update("update student set name=?,age=?,sex=? where id=?", "红红", "13", "女", "3");
        System.out.println(row);
    }
    @Test
    public void testDelete(){
        int row = jdbcTemplate.update("delete from student where id=?", "6");
        System.out.println(row);
    }
    @Test
    public void testQueryAll(){
        List<User> userList = jdbcTemplate.query("select * from student", new BeanPropertyRowMapper<User>(User.class));
        System.out.println(userList);
    }
    @Test
    public void testQueryOne(){
        User user = jdbcTemplate.queryForObject("select * from student where id=?", new BeanPropertyRowMapper<User>(User.class), "1");
        System.out.println(user);
    }
    @Test
    public void testQueryCount(){
        Long count = jdbcTemplate.queryForObject("select count(*) from student", Long.class);
        System.out.println(count);
    }
}
