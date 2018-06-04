package com.cn.frank.test.guava;

/**
 * Author: frank_du
 * Time : 2017/7/5 上午10:59
 */
public class City {

    private String name;
    private String zipCode;
    private Integer population;
    private String climate;
    private double averageRainfall;

    public City(){}
    public City(String name){
        this(name,null,null);
    }

    public City(String name, String zipCode) {
        this.name = name;
        this.zipCode = zipCode;
    }

    public City(String name, String zipCode, Integer population){
        this.name=name;
        this.zipCode=zipCode;
        this.population=population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public double getAverageRainfall() {
        return averageRainfall;
    }

    public void setAverageRainfall(double averageRainfall) {
        this.averageRainfall = averageRainfall;
    }

    @Override
    public String toString() {
        return name;
    }
}
