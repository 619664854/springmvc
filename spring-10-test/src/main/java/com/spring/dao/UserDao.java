package com.spring.dao;

import com.spring.domain.User;

import java.util.List;

/**
 * @ClassName:UserDao
 * @Author Mr.guo
 * @Date
 */
public interface UserDao {
    List<User> findAll();

    int save(User user);
}
