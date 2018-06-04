package com.cn.frank.test.concurrent;

/**
 * Author: frank_du
 * Time : 2018/3/22 下午7:35
 */
public class WaitNotifyTest {

    public static void main(String[] args) {
        try {
            Object object = new Object();
            MyThread1 thread3 = new MyThread1(object);
            thread3.setName("3");
            thread3.start();
            Thread.sleep(1000);

            MyThread1 thread1 = new MyThread1(object);
            thread1.setName("1");
            thread1.start();


            Thread.sleep(3000);
            MyThread2 myThread2 = new MyThread2(object);
            myThread2.setName("2");
            myThread2.start();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
