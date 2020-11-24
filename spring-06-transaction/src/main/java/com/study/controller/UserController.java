package com.study.controller;

import com.study.domain.User;
import com.study.service.UserService;
import com.study.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

//@ComponentScan("com.study")
//@PropertySource("classpath:applicationContext.xml")
public class UserController {


    public static void main(String[] args) {
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.study");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        User user = new User();
        user.setId(UUID.randomUUID().toString().replaceAll("-",""));
        user.setName("自强");
        user.setAge("23");
        user.setSex("男");
        userService.saveUser(user);
    }
}
