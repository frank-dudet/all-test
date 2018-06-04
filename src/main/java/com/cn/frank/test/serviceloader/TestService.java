package com.cn.frank.test.serviceloader;

/**
 * Author: frank_du
 * Time : 2017/9/12 下午4:30
 */
public class TestService implements ITestService {
    @Override
    public String sayHello(String msg) {
        System.out.println(msg);
        return "received " + msg;
    }
}
