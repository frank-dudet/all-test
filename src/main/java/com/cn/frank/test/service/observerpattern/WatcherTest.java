package com.cn.frank.test.service.observerpattern;

import com.cn.frank.test.service.observerpattern.impl.ConcreteWatcher;
import com.cn.frank.test.service.observerpattern.impl.ConcreteWatched;

/**
 * Author: frank_du
 * Time : 2017/2/28 下午1:09
 */
public class WatcherTest {

    public static void main(String args[]) {

        Watched watched = new ConcreteWatched();

        Watcher watcher1 = new ConcreteWatcher();
        Watcher watcher2 = new ConcreteWatcher();
        Watcher watcher3 = new ConcreteWatcher();

        watched.addWatcher(watcher1);
        watched.addWatcher(watcher2);
        watched.addWatcher(watcher3);

        watched.notifyWatchers("开心");


    }
}
