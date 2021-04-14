package com.spring.dao;

import com.spring.domain.User;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName:UserDao
 * @Author Mr.guo
 * @Date
 */
public interface UserMapper {
    List<User> findAll();
    User findById(int id);
    void save(User user);
    void update(User user);
    void delte(int id);
}
