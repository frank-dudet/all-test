package com.cn.frank.test.service.observerpattern.impl;

import com.cn.frank.test.service.observerpattern.Watcher;

/**
 * Author: frank_du
 * Time : 2017/2/28 下午12:24
 */
public class ConcreteWatcher implements Watcher {

    public void update(Object object) {
        System.out.println((String) object);
    }
}
