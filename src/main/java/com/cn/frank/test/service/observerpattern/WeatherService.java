package com.cn.frank.test.service.observerpattern;

/**
 * Author: frank_du
 * Time : 2017/2/28 上午10:48
 */
public class WeatherService {

    public static void main(String args[]) {

        Earth e = new Earth();
        Satellite satellite = new Satellite();
        e.addObserver(satellite);

        System.out.println("天气预报: ");
        System.out.println(" ------" +
                " ");
        e.setWeather("台风接近了");
        e.setWeather("大到暴雨");
        e.setWeather("天气炎热");



    }
}
