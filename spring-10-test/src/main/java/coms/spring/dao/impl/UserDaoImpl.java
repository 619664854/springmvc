package coms.spring.dao.impl;

import coms.spring.dao.UserDao;
import coms.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:UserDaoImpl
 * @Author Mr.guo
 * @Date 2021/4/9 21:51
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        List<User> userList = jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<User>(User.class));
        /*userList.forEach(user->{
            List<Role> query = jdbcTemplate.query("select a.* from sys_role a,sys_user_role b where a.id=b.id and b.userId=?", new BeanPropertyRowMapper<Role>(Role.class));
        });*/
        return userList;
    }

    @Override
    public Long save(final User user) {
       //1.创建PreparedStatmentCreator
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                //使用原始的jdbc完成一个PreparedStatement的组建
                PreparedStatement preparedStatement = connection.prepareStatement("insert into sys_user values (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1,null);
                preparedStatement.setObject(2,user.getUsername());
                preparedStatement.setObject(3,user.getEmail());
                preparedStatement.setObject(4,user.getPassword());
                preparedStatement.setObject(5,user.getPhoneNum());
                return preparedStatement;
            }
        };
        //2.创建KeyHolder
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(creator, keyHolder);
        //3.获取住建userId
        long userId = keyHolder.getKey().longValue();
        return userId;
    }

    @Override
    public void saveUserRoleRel(Long userId, Long[] roleIds) {
        List<Object[]> values = new ArrayList<>();
        for (long roleId : roleIds){
            Object[] objs = new Object[2];
            objs[0] = userId;
            objs[1] = roleId;
            values.add(objs);
        }
        jdbcTemplate.batchUpdate("insert into sys_user_role values (?,?)",values);
    }

    @Override
    public int delUser(Long userId) {
        jdbcTemplate.update("delete from sys_user_role where userId=?",userId);
        int num = jdbcTemplate.update("delete from sys_user where id=?",userId);
        return num;
    }

    @Override
    public User findUserById(Long id) {
//        User user = jdbcTemplate.query("select * from sys_user where id=?",new BeanPropertyRowMapper<User>(User.class),id);
        return null;
    }

    @Override
    public User login(String userName, String passWord) throws EmptyResultDataAccessException {
        User user = jdbcTemplate.queryForObject( "select * from sys_user where username=? and password=?",new BeanPropertyRowMapper<User>(User.class),userName,passWord);
        return user;
    }

}
