package com.cn.frank.test.concurrent;

/**
 * Author: frank_du
 * Time : 2018/3/22 上午11:18
 */
public class DeadThread implements Runnable {

    public String username;

    public Object lock1 = new Object();

    public Object lock2 = new Object();

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void run() {

        if(username.equals("a")) {
            synchronized (lock1) {
                try {
                    System.out.println("username = " + username);
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("按lock1 -> lock2代码顺序执行了");
                }
            }
        }

        if(username.equals("b")) {
            synchronized (lock2) {
                try {
                    System.out.println("username = " + username);
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("按lock2 -> lock1代码顺序执行了");
                }
            }
        }

    }
}
