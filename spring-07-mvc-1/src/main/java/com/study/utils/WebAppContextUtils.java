package com.study.utils;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

public class WebAppContextUtils {

    public static ApplicationContext getAppContext(ServletContext servletContext){
        return (ApplicationContext) servletContext.getAttribute("app");
    }
}
