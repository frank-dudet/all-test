package com.cn.frank.test.service.observerpattern;

import java.util.Observable;

/**
 * Author: frank_du
 * Time : 2017/2/28 上午10:43
 */
public class Earth extends Observable {

    private String weather = "晴朗";

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
        setChanged();
        notifyObservers(weather);
    }
}
