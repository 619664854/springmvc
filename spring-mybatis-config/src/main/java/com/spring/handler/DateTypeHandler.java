package com.spring.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @ClassName:DateHandler
 * @Author Mr.guo
 * @Date 2021/4/16 23:09
 */
public class DateTypeHandler extends BaseTypeHandler<Date> {

    //将java类型转换为数据库类型需要的数据
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        preparedStatement.setLong(i,date.getTime());
    }
    //将数据库中的数据类型转换成java中需要的类型

    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        long aLong = resultSet.getLong(i);
        return new Date(aLong);
    }

    //将数据库中的数据类型转换成java中需要的类型

    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        long aLong = callableStatement.getLong(i);
        return new Date(aLong);
    }

    //将数据库中的数据类型转换成java中需要的类型
    //stirng参数为数据库中的字段名称
    //resultSet是查询出来的结果集
    @Override
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        //将获得的数据转换成Date类型
        long aLong = resultSet.getLong(s);
        return new Date(aLong);
    }
}
