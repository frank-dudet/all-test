package com.cn.frank.test.guava;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: frank_du
 * Time : 2017/7/5 上午10:58
 */
public class State {

    private String name;
    private String code;
    private String region;
    private Set<City> mainCities = new HashSet<City>();

    public State() {
    }

    public State(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Set<City> getMainCities() {
        return mainCities;
    }

    public void setMainCities(Set<City> mainCities) {
        this.mainCities = mainCities;
    }

    public void addCity(City city) {
        mainCities.add(city);
    }
}
