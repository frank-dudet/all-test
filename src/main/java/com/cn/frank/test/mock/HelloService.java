package com.cn.frank.test.mock;

/**
 * Author: frank_du
 * Time : 2018/6/8 下午4:03
 */
public class HelloService {

    public String sayHello(String name) {
        return "hello " + name;
    }

    public void show() {
        System.out.println("HelloService.show()");
    }
}
