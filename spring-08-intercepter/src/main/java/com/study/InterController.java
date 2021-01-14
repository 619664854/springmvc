package com.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InterController {

    @RequestMapping("/study")
    public ModelAndView Study(ModelAndView modelAndView){
        System.out.println(1);
        modelAndView.setViewName("study");
        modelAndView.addObject("name","爱丽丝肯德基");
        return modelAndView;
    }

}
