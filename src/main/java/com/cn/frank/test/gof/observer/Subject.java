package com.cn.frank.test.gof.observer;

/**
 * Author: frank_du
 * Time : 2017/3/15 下午4:25
 */
public interface Subject {

    void add(Observer observer);

    void remove(Observer observer);

    void notifyObservers();

    void operation();
}
