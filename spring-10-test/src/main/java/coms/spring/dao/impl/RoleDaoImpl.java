package coms.spring.dao.impl;

import coms.spring.dao.RoleDao;
import coms.spring.domain.Role;
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

    @Override
    public List<Role> findAll() {
        List<Role> roleList = jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));
        return roleList;
    }

    @Override
    public int save(Role role) {
        int update = jdbcTemplate.update("insert into sys_role values (?,?,?)", null, role.getRoleName(), role.getRoleDesc());
        return update;
    }

    @Override
    public List<Role> findAllByUserId(Long id) {
        List<Role> roles = jdbcTemplate.query("select * from sys_role a,sys_user_role b where a.id=b.roleId and b.userId=?", new BeanPropertyRowMapper<Role>(Role.class), id);
        return roles;
    }
}
