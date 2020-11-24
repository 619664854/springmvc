package com.study.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/quick9")
    @ResponseBody
    public User getJsonObject2(User user) throws JsonProcessingException {
        return user;
    }

    @RequestMapping("/quick8")
    @ResponseBody
    public User getJsonObject1(String name,int age) throws JsonProcessingException {
        User user = new User();
        user.setUserName(name);
        user.setAge(age);
        return user;
    }

    @RequestMapping("/quick7")
    @ResponseBody
    public User getJsonObject() throws JsonProcessingException {
        User user = new User();
        user.setUserName("张三");
        user.setAge(10);
        return user;
    }

    @RequestMapping("/quick6")
    @ResponseBody
    public String getJson(HttpServletRequest request) throws JsonProcessingException {
        User user = new User();
        user.setUserName("张三");
        user.setAge(10);
        //使用json转换工具转换成json格式字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);
        return json;
    }

    @RequestMapping("/quick5")
    public String getJsp3(HttpServletRequest request){
        request.setAttribute("user","a2a1");
        return "success";
    }

    @RequestMapping("/quick4")
    public String getJsp2(Model model){
        model.addAttribute("user","a2a1");
        return "success";
    }

    @RequestMapping("/quick3")
    public ModelAndView getJsp1(ModelAndView modelAndView){
        //设置视图
        modelAndView.setViewName("success");
        //封装数据
        modelAndView.addObject("user","a2a1");
        return modelAndView;
    }

    @RequestMapping("/quick2")
    public ModelAndView getJsp(){
        /*
            Model 封装数据
            View 展示页面
         */
        ModelAndView modelAndView = new ModelAndView();
        //设置视图
        modelAndView.setViewName("success");
        //封装数据
        modelAndView.addObject("user","a1a1");
        return modelAndView;
    }

    @RequestMapping("/quick")
    public String getUser(){
        System.out.println("running123");
        return "success";/*如果添加了部资源视图解析器InternalResourceViewResolver*/
    }
}
