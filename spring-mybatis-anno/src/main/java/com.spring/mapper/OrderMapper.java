package com.spring.mapper;

import com.spring.domain.Order;
import com.spring.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName:OrderMapper
 * @Author Mr.guo
 * @Date 2021/4/18 19:03
 */
public interface OrderMapper {

    @Select("select *,o.id oid from orders o, user u where o.pid=u.id")
    @Results({
            @Result(column = "oid",property = "id"),
            @Result(column = "ordertime",property = "ordertime"),
            @Result(column = "total",property = "total"),
            @Result(
                    property = "user", //实体类中属性名
                    column = "pid",//数据库中外键字段
                    javaType = User.class,//属性名对应实体类
                    one = @One(
                            //select 代表查询哪个接口的方法获取数据
                            select = "com.spring.mapper.UserMapper.findById"
                    )
            )
    })
    List<Order> findAll();
/*
    @Select("select *,o.id oid from orders o, user u where o.pid=u.id")
    @Results({
            @Result(column = "oid",property = "id"),
            @Result(column = "ordertime",property = "ordertime"),
            @Result(column = "total",property = "total"),
            @Result(column = "pid",property = "user.id"),
            @Result(column = "username",property = "user.username"),
            @Result(column = "password",property = "user.password")
    })
    List<Order> findAll();
*/
}
