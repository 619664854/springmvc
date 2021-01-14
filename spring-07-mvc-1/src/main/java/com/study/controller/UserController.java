package com.study.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.domain.User;
import com.study.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/quick17")
    @ResponseBody
    /**
     * //http://127.0.0.1:8080/spring/user/quick17 多文件上传
     * MultipartFile upload 需要与上传文件名称一致
     */
    public void test17(String userName, MultipartFile[] upload) throws IOException {
        System.out.println(userName);
        for (MultipartFile upload1:upload) {
            upload1.transferTo(new File("D:\\test\\"+upload1.getOriginalFilename()));
        }
    }

    @RequestMapping("/quick16")
    @ResponseBody
    /**
     * //http://127.0.0.1:8080/spring/user/quick16 文件上传
     * MultipartFile upload 需要与上传文件名称一致
     */
    public void test16(String userName, MultipartFile upload) throws IOException {
        System.out.println(userName);
        upload.transferTo(new File("D:\\"+upload.getOriginalFilename()));
    }

    @RequestMapping("/quick15")
    @ResponseBody
    //http://127.0.0.1:8080/spring/user/quick15 获取请求头内容
    public void test15(@RequestHeader(value = "User-Agent",required = false) String userAgent,@CookieValue(value = "JSESSIONID",required = false)String sessionId)  {
        System.out.println(userAgent);
        System.out.println(sessionId);
    }

    @RequestMapping("/quick14")
    @ResponseBody
    //http://127.0.0.1:8080/spring/user/quick14
    //格式类型转换器测试
    /*
    * 1.创建格式类型转换器 实现org.springframework.core.convert.converter.Converter
    * 2.自己设置转换方法
    * 3.在spring-mvc.xml中配置转换工厂 以及在mvc:annotation-driven中配置conversion-service指定对应的bean
    * */
    public void test14(Date date)  {
        System.out.println(date);
    }

    @RequestMapping("/quick13/{name}")
    @ResponseBody   //http://127.0.0.1:8080/spring/user/quick13/zhangsan Restful风格获取：get获取 post 新增 put 更新 delete 删除
    public void getJsonObject3(@PathVariable("name") String username)  {
        System.out.println(username);
    }

    @RequestMapping("/quick12")
    @ResponseBody   //http://127.0.0.1:8080/spring/user/quick12?name=zhangsan
    // 默认请求必须存在参数 如果不是必须的可以设置required为false
    public void getJsonObject2(@RequestParam(value = "name",required = false) String username)  {
        System.out.println(username);
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
