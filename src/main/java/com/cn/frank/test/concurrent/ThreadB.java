package com.cn.frank.test.concurrent;

/**
 * Author: frank_du
 * Time : 2018/3/22 上午11:06
 */
public class ThreadB extends Thread {
    private TestService service;

    public ThreadB(TestService service) {
        this.service = service;
    }


    @Override
    public void run() {
        super.run();
        service.printB();
    }
}
