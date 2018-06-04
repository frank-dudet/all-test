package com.cn.frank.test.callback;

/**
 * Author: frank_du
 * Time : 2017/4/26 上午9:47
 */
public class CallBackTest {

    public static void main(String[] args) {

        Student student = new Ricky();

        Teacher t = new Teacher(student);

        t.askQuestion(student);
    }
}
