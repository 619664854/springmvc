package com.study.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect //标注当前类是一个切面类
public class MyAspect {

    @Before("execution(* com.study.anno.*.*(..))")
    public void before(){
        System.out.println("前置增强...");
    }
    @AfterReturning("execution(* com.study.anno.*.*(..))")
    public void afterReturning(){
        System.out.println("后置增强...");
    }
    //ProceedingJoinPoint 正在执行的连接点==切点
    @Around("execution(* com.study.anno.*.*(..))")
    public Object round(ProceedingJoinPoint point) throws Throwable {
        System.out.println("环绕前增强...");
        Object proceed = point.proceed();
        System.out.println("环绕后增强...");
        return proceed;
    }
    //定义切点表达式
    @Pointcut("execution(* com.study.anno.*.*(..))")
    public void pointCut(){}
    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("抛出异常增强...");
    }
    @After("MyAspect.pointCut()")
    public void after(){
        System.out.println("最终增强...");
    }
}
