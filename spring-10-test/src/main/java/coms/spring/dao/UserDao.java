package coms.spring.dao;

import coms.spring.domain.User;

import java.util.List;

/**
 * @ClassName:UserDao
 * @Author Mr.guo
 * @Date
 */
public interface UserDao {
    List<User> findAll();

    Long save(User user);

    void saveUserRoleRel(Long userId, Long[] roleIds);

    int delUser(Long userId);

    User findUserById(Long id);

    User login(String userName, String passWord);
}
