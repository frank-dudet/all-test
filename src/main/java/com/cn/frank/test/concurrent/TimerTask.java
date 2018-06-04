package com.cn.frank.test.concurrent;

import java.util.Timer;

/**
 * Author: frank_du
 * Time : 2018/4/5 下午2:50
 */
public class TimerTask {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new ThrowTask(),1);

        Thread.sleep(1000);
        timer.schedule(new ThrowTask(),1);
        Thread.sleep(5000);
    }

    static class ThrowTask extends java.util.TimerTask {

        @Override
        public void run() {
            throw new RuntimeException();
        }
    }
}
