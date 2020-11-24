package com.study.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //读取web.xml中的全局参数
        ServletContext servletContext = servletContextEvent.getServletContext();
        String contextConfigLoaction = servletContext.getInitParameter("contextConfigLoaction");
        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLoaction);
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //将spring的应用上下文对象存储到ServletCo域中ntext
        servletContextEvent.getServletContext().setAttribute("app",app);



        System.out.println("监听器启动成功");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
