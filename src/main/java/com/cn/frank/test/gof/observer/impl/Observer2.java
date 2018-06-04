package com.cn.frank.test.gof.observer.impl;

import com.cn.frank.test.gof.observer.Observer;

/**
 * Author: frank_du
 * Time : 2017/3/15 下午4:28
 */
public class Observer2 implements Observer {

    public void update() {
        System.out.println("Observer2 received!");
    }
}
