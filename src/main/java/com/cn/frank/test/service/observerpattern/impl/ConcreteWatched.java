package com.cn.frank.test.service.observerpattern.impl;

import com.cn.frank.test.service.observerpattern.Watcher;
import com.cn.frank.test.service.observerpattern.Watched;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: frank_du
 * Time : 2017/2/28 下午12:24
 */
public class ConcreteWatched implements Watched{


    List<Watcher> watcherList = new ArrayList<Watcher>();

    public void addWatcher(Watcher watcher) {
        watcherList.add(watcher);
    }

    public void removeWatcher(Watcher watcher) {
        watcherList.remove(watcher);
    }

    public void notifyWatchers(Object o) {
        for(Watcher watcher : watcherList) {
            watcher.update(o);
        }
    }
}
