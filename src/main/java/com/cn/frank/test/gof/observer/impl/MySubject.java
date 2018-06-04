package com.cn.frank.test.gof.observer.impl;

import com.cn.frank.test.gof.observer.AbstractSubject;
import com.cn.frank.test.gof.observer.Subject;

/**
 * Author: frank_du
 * Time : 2017/3/15 下午4:35
 */
public class MySubject extends AbstractSubject {

    public void operation() {
        System.out.println("update self!");
        notifyObservers();
    }

    public static void main(String args[]) {

        Subject subject = new MySubject();
        subject.add(new Observer1());
        subject.add(new Observer2());

        subject.operation();
    }
}
