package com.cn.frank.test.thread;

/**
 * Author: frank_du
 * Time : 2017/9/7 上午9:59
 */
public class VolatileTest {

    public volatile String value;

    public static void main(String[] args) {
        VolatileTest test = new VolatileTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.setValue("test");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(test.getValue());
            }
        }).start();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
