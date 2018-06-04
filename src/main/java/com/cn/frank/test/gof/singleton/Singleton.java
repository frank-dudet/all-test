package com.cn.frank.test.gof.singleton;

/**
 * Author: frank_du
 * Time : 2017/3/15 下午3:07
 */
public class Singleton {

    private Singleton (){

    }

    private static class InstanceHolder{
        private static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return InstanceHolder.instance;
    }

    //序列化
    public Object readResolve(){
        return getInstance();
    }
}
