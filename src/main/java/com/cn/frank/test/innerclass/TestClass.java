package com.cn.frank.test.innerclass;


/**
 * Author: frank_du
 * Time : 2017/9/19 上午10:56
 */
public class TestClass implements Runnable {

    public static void main(String[] args) {
        new Thread(new TestClass()).start();
        new Thread(new TestClass()).start();
        new Thread(new TestClass()).start();
    }

    @Override
    public void run() {
        System.out.println(OuterClass.getValue());
    }
}
