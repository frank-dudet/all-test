package com.cn.frank.test.service.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Author: frank_du
 * Time : 2017/3/15 下午5:42
 */
public class GamePlayerInvocationHandler implements InvocationHandler {

    private Object object;

    public GamePlayerInvocationHandler(Object object) {
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke " + method.getName());
        method.invoke(object,args);
        System.out.println("after invoke " + method.getName());
        return null;

    }
}
