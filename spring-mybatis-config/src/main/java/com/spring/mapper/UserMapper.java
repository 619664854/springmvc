package com.spring.mapper;

import com.spring.domain.User;

/**
 * @ClassName:UserDao
 * @Author Mr.guo
 * @Date
 */
public interface UserMapper {
    public void save(User user);
    public User findById(int id);
}
