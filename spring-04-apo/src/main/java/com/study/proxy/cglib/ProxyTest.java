package com.study.proxy.cglib;

import com.study.proxy.jdk.TargetInterface;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        //创建目标对象
        Target target = new Target();
        //获得增强对象
        Advice advice = new Advice();
        //返回值 就是动态生成的代理对象 基于cglib
        //1.创建增强器
        Enhancer enhancer = new Enhancer();
        //2.设置父类
        enhancer.setSuperclass(Target.class);
        //3.设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                advice.before(); //执行前置
                method.invoke(target,args);//执行目标
                advice.after();//执行后置
                return null;
            }
        });
        //4.生成代理对象
        Target proxy = (Target) enhancer.create();
        proxy.save();
        proxy.update();
    }
}
