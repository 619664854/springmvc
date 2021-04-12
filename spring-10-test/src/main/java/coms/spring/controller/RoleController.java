package coms.spring.controller;

import coms.spring.domain.Role;
import coms.spring.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName:RoleController
 * @Author Mr.guo
 * @Date 2021/4/8 21:26
 * 与角色有关的Controller
 */
@Controller()
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * @Author Mr.guo
     * @Description 获取角色信息
     * @Date 21:32 2021/4/8
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.list();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("role-list");
        return  modelAndView;
    }
    /**
     * @Author Mr.guo
     * @Description //添加角色信息
     * @Date 21:26 2021/4/9
     * @Param [role]
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return  "redirect:/role/list";
    }
}
