package com.study.service.impl;

import com.study.dao.UserDao;
import com.study.domain.User;
import com.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//@Service
public class UserServiceImpl implements UserService {

//    @Resource
//    private  UserDao userDao;

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void saveUser(User user) {
        userDao.addUser(user);
        user.setAge("254");
        int a = 1/0;
        userDao.updateUser(user);
    }
}
