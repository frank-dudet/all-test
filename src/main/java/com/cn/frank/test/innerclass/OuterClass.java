package com.cn.frank.test.innerclass;


/**
 * Author: frank_du
 * Time : 2017/9/19 上午10:53
 */
public class OuterClass {

    private OuterClass() {
    }

    private static final class InnerClass {
        private InnerClass() {
        }

        static String s;
        static {
            s = "initial";
            System.out.println("InnerClass init, static");
        }
    }

    public static String getValue() {
        return InnerClass.s;
    }
}
