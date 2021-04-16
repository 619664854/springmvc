package com.spring.mapper;

import com.spring.domain.User;

import java.util.List;

/**
 * @ClassName:UserDao
 * @Author Mr.guo
 * @Date
 */
public interface UserMapper {
    List<User> findByCondition(User user);
    List<User> findById(List<Integer> ids);
}
