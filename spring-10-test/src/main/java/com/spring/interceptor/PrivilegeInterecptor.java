package com.spring.interceptor;

import com.spring.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName:Privilege
 * @Author Mr.guo
 * @Date 2021/4/11 15:36
 * 用户登录拦截器
 */
public class PrivilegeInterecptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        //判断用户是否登录
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null){
            //用户未登录
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return false;
        }
        //用户已登录 放行
        return  true;
    }
}
