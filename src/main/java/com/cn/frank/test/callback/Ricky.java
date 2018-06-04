package com.cn.frank.test.callback;

/**
 * Author: frank_du
 * Time : 2017/4/26 上午9:44
 */
public class Ricky implements Student {

    public String resolveProblem(CallBack callBack) {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return callBack.tellAnswer("2");
    }
}
