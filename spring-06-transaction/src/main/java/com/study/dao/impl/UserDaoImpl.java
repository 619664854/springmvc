package com.study.dao.impl;

import com.study.dao.UserDao;
import com.study.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository("userDao")
public class UserDaoImpl implements UserDao {

//    @Autowired
//    private JdbcTemplate jdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addUser(User user) {
        jdbcTemplate.update("insert into student values (?,?,?,?)",user.getId(),user.getName(),user.getAge(),user.getSex());
    }

    @Override
    public void updateUser(User user) {
        jdbcTemplate.update("update student set name=?,age=?,sex=? where id=?",user.getName(),user.getAge(),user.getSex(),user.getId());
    }
}
