package coms.spring.service.impl;

import coms.spring.dao.RoleDao;
import coms.spring.dao.UserDao;
import coms.spring.domain.Role;
import coms.spring.domain.User;
import coms.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName:UserServiceImpl
 * @Author Mr.guo
 * @Date 2021/4/9 21:44
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;
    @Override
    public List<User> list() {
        List<User> userList = userDao.findAll();
        //获取用户对应的角色信息
        for (User user : userList) {
            Long id = user.getId();
            //讲id作为参数 查询当前用户对应的角色信息
            List<Role> roleList = roleDao.findAllByUserId(id);
            user.setRoles(roleList);
        }
        return userList;
    }

    @Override
    public void save(User user, Long[] roleIds) {
        //保存user信息
        Long userId = userDao.save(user);
        //想sys_user_role存储关联关系数据
        userDao.saveUserRoleRel(userId,roleIds);
    }

    @Override
    public int del(Long userId) {
        int num = userDao.delUser(userId);
        return num;
    }

    @Override
    public User findUserById(Long id) {
        User user = userDao.findUserById(id);
        return null;
    }

    @Override
    public User login(String userName, String passWord) {
        User user = null;
        try {
            user = userDao.login(userName,passWord);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }
}
