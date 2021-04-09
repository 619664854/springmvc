package com.spring.service.impl;

import com.spring.dao.RoleDao;
import com.spring.domain.Role;
import com.spring.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName:RoleServiceImpl
 * @Author Mr.guo
 * @Date 2021/4/8 21:40
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> list() {
        List<Role> roleList = roleDao.findAll();
        return roleList;
    }

    @Override
    public void save(Role role) {
        int num = roleDao.save(role);
    }
}
