package com.cn.frank.test.bean;

import java.io.Serializable;

/**
 * Author: frank_du
 * Time : 2017/4/12 上午10:11
 */
public class DishItem implements Serializable{


    private static final long serialVersionUID = 459633785886318284L;


    private String dishNo;

    private String dishName;


    public String getDishNo() {
        return dishNo;
    }

    public void setDishNo(String dishNo) {
        this.dishNo = dishNo;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DishItem)) return false;

        DishItem dishItem = (DishItem) o;

        if (getDishNo() != null ? !getDishNo().equals(dishItem.getDishNo()) : dishItem.getDishNo() != null)
            return false;
        return getDishName() != null ? getDishName().equals(dishItem.getDishName()) : dishItem.getDishName() == null;

    }

    @Override
    public int hashCode() {
        int result = getDishNo() != null ? getDishNo().hashCode() : 0;
        result = 31 * result + (getDishName() != null ? getDishName().hashCode() : 0);
        return result;
    }
}
