package com.cn.frank.test.concurrent;

/**
 * Author: frank_du
 * Time : 2018/3/22 上午11:03
 */
public class TestMain {

    public static void main(String[] args) {
        TestService service1 = new TestService();
        TestService service2 = new TestService();


        Thread t1 = new ThreadA(service1);
        t1.setName("A");
        t1.start();

        Thread t2 = new ThreadB(service1);
        t2.setName("B");
        t2.start();
    }
}
