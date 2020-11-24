package com.service.impl;

import com.dao.UserDao;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/*<bean id="userService" class="com.service.impl.UserServiceImpl">

</bean>*/
//@Component("userService")
@Service("userService")
//@Scope("singleton")
//@Scope("prototype")

public class UserServiceImpl implements UserService {
    @Value("${jdbc.url}")
    private String cardId;

    //<property name="userDao" ref="userDao"></property>
    //@Autowired//按照数据类型从spring容器中进行匹配
    //@Qualifier("userDao") //按照id从容器中进行匹配 但是@Qualifier需要与@Autowired一起使用
    @Resource(name = "userDao")//@Resource相当于@Qualifier+@Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        System.out.println(cardId);
        userDao.save();
    }
    @PostConstruct
    public void init(){
        System.out.println("初始化...");
    }
    @PreDestroy
    public void destory(){
        System.out.println("销毁...");
    }
}
