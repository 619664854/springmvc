package coms.spring.controller;

import coms.spring.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName:DemoController
 * @Author Mr.guo
 * @Date 2021/4/12 21:12
 * 测试Demo
 */
@Controller
@RequestMapping("/test")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/show")
    public void show(){
        System.out.println(111);
        demoService.show();
    }
}
