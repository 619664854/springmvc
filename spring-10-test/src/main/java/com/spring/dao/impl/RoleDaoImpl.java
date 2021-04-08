package com.spring.dao.impl;

import com.spring.dao.RoleDao;
import com.spring.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName:RoleDaoImpl
 * @Author Mr.guo
 * @Date 2021/4/8 21:45
 */
@Repository("roleDao")
public class RoleDaoImpl implements RoleDao {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    /*public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }*/

    @Override
    public List<Role> findAll() {
        List<Role> roleList = jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));
        return roleList;
    }
}
