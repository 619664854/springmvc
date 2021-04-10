package com.spring.controller;

import com.spring.domain.Role;
import com.spring.domain.User;
import com.spring.service.RoleService;
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
    @Autowired
    private RoleService roleService;
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
    @RequestMapping("/userUI")
    public ModelAndView saveUI(){
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.list();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-add");
        return  modelAndView;
    }

    @RequestMapping("/save")
    public String save(User user,Long[] roleIds){
        userService.save(user,roleIds);
        return "redirect:/user/list";
    }
}
