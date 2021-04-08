package com.spring.dao;

import com.spring.domain.Role;

import java.util.List;

/**
 * @ClassName:RoleDao
 * @Author Mr.guo
 * @Date
 */
public interface RoleDao {
    List<Role> findAll();
}
