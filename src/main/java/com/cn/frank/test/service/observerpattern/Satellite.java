package com.cn.frank.test.service.observerpattern;

import java.util.Observable;
import java.util.Observer;

/**
 * Author: frank_du
 * Time : 2017/2/28 上午10:44
 */
public class Satellite implements Observer {

    private String weather;

    public void update(Observable o, Object arg) {

        weather = (String) arg;
        System.out.println("近期天气变化：" + weather);

    }
}