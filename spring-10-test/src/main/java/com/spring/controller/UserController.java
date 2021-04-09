package com.spring.controller;

import com.spring.domain.User;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName:UserController
 * @Author Mr.guo
 * @Date 2021/4/8 21:26
 * 与角色有关的Controller
 */
@Controller()
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @Author Mr.guo
     * @Description 获取用户信息列表
     * @Date 21:32 2021/4/8
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        List<User> userList = userService.list();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("user-list");
        return  modelAndView;
    }
    /**
     * @Author Mr.guo
     * @Description //添加用户信息
     * @Date 21:26 2021/4/9
     * @Param [role]
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("/save")
    public String save(User user){
        userService.save(user);
        return  "redirect:/role/list";
    }
}
