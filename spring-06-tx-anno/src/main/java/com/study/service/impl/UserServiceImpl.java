package com.study.service.impl;

import com.study.dao.UserDao;
import com.study.domain.User;
import com.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("userService")
@Transactional//可以放在类上也可以放在方法上
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserDao userDao;

    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.addUser(user);
        user.setAge("254");
        int a = 1/0;
        userDao.updateUser(user);
    }
}
