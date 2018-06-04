package com.cn.frank.test.concurrent.threadpool;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Author: frank_du
 * Time : 2018/4/28 下午5:09
 */
public class ScheduleExecutorServiceDemo {
    private final static ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(5);

    public static void main(String args[]){
        final Runnable beeper = () -> {
            System.out.println(Thread.currentThread().getName()+" >>> "+ LocalTime.now().toString()+" >>> beep");

            //TODO 沉睡吧，少年
            try {
                TimeUnit.SECONDS.sleep(3L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        //从0s开始输出beep，间隔1s
        final ScheduledFuture<?> beeperHandle =
                scheduler.scheduleAtFixedRate(beeper, 0, 1, TimeUnit.SECONDS);

        //10s之后停止beeperHandle的疯狂输出行为
        scheduler.schedule(new Runnable() {
            public void run() {
                System.out.println("觉悟吧，beeperHandle！I will kill you!");
                beeperHandle.cancel(true);
            }
        }, 10, TimeUnit.SECONDS);
    }
}
