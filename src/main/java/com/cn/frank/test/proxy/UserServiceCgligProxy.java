package com.cn.frank.test.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Author: frank_du
 * Time : 2017/10/12 下午5:15
 */
public class UserServiceCgligProxy implements MethodInterceptor {

    private Object object;

    public Object getInstance(Object object) {
        this.object = object;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib Before:" + method);
        Object result = methodProxy.invoke(object, objects);
        System.out.println("Cglib After:" + method);
        return result;
    }
}
