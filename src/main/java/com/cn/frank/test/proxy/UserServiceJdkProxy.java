package com.cn.frank.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author: frank_du
 * Time : 2018/4/10 上午11:11
 */
public class UserServiceJdkProxy implements InvocationHandler {

    private Object object;

    public Object bind(Object target) {
        this.object = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk before " + method.getName());
        Object result = method.invoke(object, args);
        System.out.println("jdk after " + method.getName());

        return result;
    }
}
