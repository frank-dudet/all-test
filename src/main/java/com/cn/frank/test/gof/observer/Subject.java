package com.cn.frank.test.gof.observer;

/**
 * Author: frank_du
 * Time : 2017/3/15 下午4:25
 */
public interface Subject {

    public void add(Observer observer);

    public void remove(Observer observer);

    public void notifyObservers();

    public void operation();
}
