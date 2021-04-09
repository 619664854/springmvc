package com.spring.service;

import com.spring.domain.User;

import java.util.List;

/**
 * @ClassName:UserService
 * @Author Mr.guo
 * @Date 2021/4/9 21:43
 */
public interface UserService {
    List<User> list();

    void save(User user);
}
