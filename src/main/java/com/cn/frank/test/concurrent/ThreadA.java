package com.cn.frank.test.concurrent;

/**
 * Author: frank_du
 * Time : 2018/3/22 上午11:08
 */
public class ThreadA extends Thread {

    private TestService service;

    public ThreadA(TestService service) {
        this.service = service;
    }


    @Override
    public void run() {
        super.run();
        service.printA();
    }
}