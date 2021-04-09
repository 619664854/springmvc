package com.spring.dao.impl;

import com.spring.dao.UserDao;
import com.spring.domain.Role;
import com.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName:UserDaoImpl
 * @Author Mr.guo
 * @Date 2021/4/9 21:51
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        List<User> userList = jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<User>(User.class));
        /*userList.forEach(user->{
            List<Role> query = jdbcTemplate.query("select a.* from sys_role a,sys_user_role b where a.id=b.id and b.userId=?", new BeanPropertyRowMapper<Role>(Role.class));
        });*/
        return userList;
    }

    @Override
    public int save(User user) {
        int update = jdbcTemplate.update("insert into sys_user values (?,?,?,?)", null, user.getUsername(), user.getEmail(), user.getPassword(), user.getPhoneNum());
        return update;
    }
}
