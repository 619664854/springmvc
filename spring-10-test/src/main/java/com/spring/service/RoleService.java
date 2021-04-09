package com.spring.service;

import com.spring.domain.Role;

import java.util.List;

/**
 * @ClassName:RoleService
 * @Author Mr.guo
 * @Date 2021/4/8 21:33
 */
public interface RoleService {
    public List<Role> list() ;

    public void save(Role role);
}
