package com.cn.frank.test.oauth2.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: frank_du
 * Time : 2018/5/24 下午3:09
 */
public class UserOverviewDto implements Serializable {

    private static final long serialVersionUID = 2023379587030489248L;


    private String username;


    private List<UserDto> userDtos = new ArrayList<>();


    public UserOverviewDto() {
    }

    public int getSize() {
        return userDtos.size();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<UserDto> getUserDtos() {
        return userDtos;
    }

    public void setUserDtos(List<UserDto> userDtos) {
        this.userDtos = userDtos;
    }

}
