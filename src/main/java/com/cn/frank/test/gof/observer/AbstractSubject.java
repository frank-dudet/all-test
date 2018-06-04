package com.cn.frank.test.gof.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Author: frank_du
 * Time : 2017/3/15 下午4:26
 */
public abstract class AbstractSubject implements Subject {


    private List<Observer> observers = new ArrayList<Observer>();

    public void add(Observer observer) {
        observers.add(observer);
    }

    public void remove(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        Iterator<Observer> iterator = observers.iterator();
        while(iterator.hasNext()) {
          iterator.next().update();
        }
    }
}
