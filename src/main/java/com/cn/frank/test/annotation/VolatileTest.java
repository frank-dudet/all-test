package com.cn.frank.test.annotation;


/**
 * Author: frank_du
 * Time : 2018/3/20 下午2:30
 */
public class VolatileTest implements Runnable {
    // private static volatile boolean flg = true;
    private static volatile MyObj obj = new MyObj();
    //private static int[] a = {0};
    private static volatile MyObj[] objs = {new MyObj()};

    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.getProperty("java.vm.name"));
//        SubObj subObj = new SubObj();
//        subObj.setFlg(true);
//        obj.setSub(subObj);
        objs[0].setFlg(true);
        new Thread(new VolatileTest()).start();
        Thread.currentThread().sleep(3000);
        System.out.println("改变标记");
        objs[0].setFlg(false);
//        subObj.setFlg(false);
    }

    @Override
    public void run() {
        System.out.println("开始");
        long i = 0;
        while (objs[0].getFlg()) {
            i++;
        }
        System.out.println("结束, i = " + i);
    }
}

class MyObj {
    public Boolean getFlg() {
        return flg;
    }

    public void setFlg(Boolean flg) {
        this.flg = flg;
    }

    private Boolean flg = true;

    private SubObj sub;

    public SubObj getSub() {
        return sub;
    }

    public void setSub(SubObj sub) {
        this.sub = sub;
    }
}

class SubObj {
    private boolean flg;
    private String str;

    public boolean isFlg() {
        return flg;
    }

    public void setFlg(boolean flg) {
        this.flg = flg;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
