package coms.spring.dao;

import coms.spring.domain.Role;

import java.util.List;

/**
 * @ClassName:RoleDao
 * @Author Mr.guo
 * @Date
 */
public interface RoleDao {
    List<Role> findAll();

    int save(Role role);

    List<Role> findAllByUserId(Long id);
}
