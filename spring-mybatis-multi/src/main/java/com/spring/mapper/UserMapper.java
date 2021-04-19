package com.spring.mapper;

import com.spring.domain.User;

import java.util.List;

/**
 * @ClassName:UserDao
 * @Author Mr.guo
 * @Date
 */
public interface UserMapper {

    public List<User> findAll();
}
