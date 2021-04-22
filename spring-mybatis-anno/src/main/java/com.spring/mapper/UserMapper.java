package com.spring.mapper;

import com.spring.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @ClassName:UserMapper
 * @Author Mr.guo
 * @Date 2021/4/22 20:53
 */
public interface UserMapper {

    @Select("select * from user where id=#{id}")
    public User findById(int id);
    @Select("select * from user")
    public List<User> findAll();
    @Insert("insert into user values (#{id},#{username},#{password})")
    public void save(User user);
    @Update("  update user set username=#{username},password=#{password}  where id=#{id}")
    public void update(User user);
    @Delete("delete from user where id=#{id}")
    public void delete(int id);
}
