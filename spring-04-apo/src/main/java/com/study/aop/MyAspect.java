package com.study.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

    public void before(){
        System.out.println("前置织入...");
    }
    public void afterReturning(){
        System.out.println("后置织入...");
    }
    //ProceedingJoinPoint 正在执行的连接点==切点
    public Object round(ProceedingJoinPoint point) throws Throwable {
        System.out.println("环绕前增强...");
        Object proceed = point.proceed();
        System.out.println("环绕后增强...");
        return proceed;
    }

    public void afterThrowing(){
        System.out.println("抛出异常增强...");
    }
    public void after(){
        System.out.println("最终增强...");
    }
}
