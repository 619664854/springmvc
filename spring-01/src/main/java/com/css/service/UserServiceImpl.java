package com.css.service;

import com.css.dao.UserDao;

public class UserServiceImpl implements UserService{


    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        userDao.save();
    }
}
