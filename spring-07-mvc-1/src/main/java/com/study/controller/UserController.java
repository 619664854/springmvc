package com.study.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.domain.User;
import com.study.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/quick12")
    @ResponseBody   //http://127.0.0.1:8080/spring/user/quick12?name=zhangsan
    // 默认请求必须存在参数 如果不是必须的可以设置required为false
    public void getJsonObject2(@RequestParam(value = "name",required = false) String username)  {
        System.out.println(username+"1");
    }

    @RequestMapping("/quick11")
    @ResponseBody
    public void getJsonObject2(VO vo)  {
        System.out.println(vo.toString());
    }

    @RequestMapping("/quick10")
    @ResponseBody
    public String getJsonObject2(String[] args)  {
        return Arrays.toString(args);
    }

    @RequestMapping("/quick9")
    @ResponseBody
    public User getJsonObject2(User user)  {
        return user;
    }

    @RequestMapping("/quick8")
    @ResponseBody
    public User getJsonObject1(String name,int age) {
        User user = new User();
        user.setUserName(name);
        user.setAge(age);
        return user;
    }

    @RequestMapping("/quick7")
    @ResponseBody
    public User getJsonObject() {
        User user = new User();
        user.setUserName("张三");
        user.setAge(10);
        return user;
    }

    @RequestMapping("/quick6")
    @ResponseBody
    public String getJson() throws JsonProcessingException {
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
        return "/jsp/success.jsp";/*如果添加了部资源视图解析器InternalResourceViewResolver*/
    }
}
