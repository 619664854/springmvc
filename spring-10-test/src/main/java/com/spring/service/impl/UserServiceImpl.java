package com.spring.service.impl;

import com.spring.dao.RoleDao;
import com.spring.dao.UserDao;
import com.spring.domain.Role;
import com.spring.domain.User;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName:UserServiceImpl
 * @Author Mr.guo
 * @Date 2021/4/9 21:44
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;
    @Override
    public List<User> list() {
        List<User> userList = userDao.findAll();
        //获取用户对应的角色信息
        for (User user : userList) {
            Long id = user.getId();
            //讲id作为参数 查询当前用户对应的角色信息
            List<Role> roleList = roleDao.findAllByUserId(id);
            user.setRoles(roleList);
        }
        return userList;
    }

    @Override
    public void save(User user) {
        int num = userDao.save(user);
    }
}
