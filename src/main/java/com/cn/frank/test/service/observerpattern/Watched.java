package com.cn.frank.test.service.observerpattern;

/**
 * Author: frank_du
 * Time : 2017/2/28 下午12:21
 */
public interface Watched {

    void addWatcher(Watcher watcher);

    void removeWatcher(Watcher watcher);

    void notifyWatchers(Object o);

}
