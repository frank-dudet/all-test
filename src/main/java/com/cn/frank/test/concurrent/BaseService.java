package com.cn.frank.test.concurrent;

/**
 * Author: frank_du
 * Time : 2018/3/28 下午6:43
 */
public class BaseService {

    public synchronized void doSomething() throws Exception {
        Thread.sleep(5000);
        System.out.println("ThreadName=" + Thread.currentThread().getName() + ", BaseService doSomething");
    }

    public static void main(String[] args) throws Exception {
        new BaseService().doSomething();
    }
}
