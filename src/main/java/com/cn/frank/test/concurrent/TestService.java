package com.cn.frank.test.concurrent;

/**
 * Author: frank_du
 * Time : 2018/3/22 上午11:00
 */
public class TestService {

    public synchronized static void printA() {
        try {
            System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
                    + System.currentTimeMillis() + "进入printA");

            Thread.sleep(3000);
            System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
                    + System.currentTimeMillis() + "离开printA");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void printB() {

        try {
            System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
                    + System.currentTimeMillis() + "进入printB");
//            Thread.sleep(3000);
            System.out.println("线程名称为：" + Thread.currentThread().getName() + "在"
                    + System.currentTimeMillis() + "离开printB");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
