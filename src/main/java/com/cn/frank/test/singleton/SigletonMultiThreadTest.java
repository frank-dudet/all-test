package com.cn.frank.test.singleton;

/**
 * Author: frank_du
 * Time : 2017/9/12 下午3:54
 */

public class SigletonMultiThreadTest implements Runnable {


    public static void main(String[] args) throws Exception {

        new Thread(new SigletonMultiThreadTest()).start();
        new Thread(new SigletonMultiThreadTest()).start();
        new Thread(new SigletonMultiThreadTest()).start();
//
//        Thread.sleep(1000);
//        System.out.println(new FetchDataBaseService().getVersion());
    }

    @Override
    public void run() {
       new FetchDataServiceImpl().fetchData();
    }
}
