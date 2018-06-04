package com.cn.frank.test.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: frank_du
 * Time : 2018/4/28 下午4:14
 */
public class FixedThreadPoolDemo {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Name: " + Thread.currentThread().getName());
            }
        };

        executorService.execute(runnable);

        executorService.shutdown();

    }
}
