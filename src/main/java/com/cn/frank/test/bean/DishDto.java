package com.cn.frank.test.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Author: frank_du
 * Time : 2017/4/12 上午10:12
 */
public class DishDto implements Serializable{


    private static final long serialVersionUID = -2049178971343064040L;

    private int shopId;

    private List<DishItem> dishes;

    private String isAppend;

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public List<DishItem> getDishes() {
        return dishes;
    }

    public void setDishes(List<DishItem> dishes) {
        this.dishes = dishes;
    }

    public String getIsAppend() {
        return isAppend;
    }

    public void setIsAppend(String isAppend) {
        this.isAppend = isAppend;
    }


}
