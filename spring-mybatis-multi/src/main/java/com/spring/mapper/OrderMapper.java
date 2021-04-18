package com.spring.mapper;

import com.spring.domain.Order;

import java.util.List;

/**
 * @ClassName:OrderMapper
 * @Author Mr.guo
 * @Date 2021/4/18 19:03
 */
public interface OrderMapper {

    List<Order> findAll();
}
