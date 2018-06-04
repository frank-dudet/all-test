package com.cn.frank.test.concurrent;

/**
 * Author: frank_du
 * Time : 2018/3/28 下午6:44
 */
public class ExtService extends BaseService {
    @Override
    public synchronized void doSomething() throws Exception {
        System.out.println("ThreadName=" + Thread.currentThread().getName() + ", ExtService  doSomething");
        Thread.sleep(1000);
        super.doSomething();
    }
}
