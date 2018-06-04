package com.cn.frank.test.clone;

import com.alibaba.fastjson.JSON;
import com.cn.frank.test.util.CommonUtils;
import com.cn.frank.test.bean.ExtUser;

import java.math.BigDecimal;

/**
 * Author: frank_du
 * Time : 2018/5/8 上午11:42
 */
public class DeepCloneTest {

    public static void main(String[] args) {
        ExtUser extUser = new ExtUser();
        extUser.setId(1);
        extUser.setUsername("张三");
        extUser.setPassword("111");
        extUser.setMoney(BigDecimal.ZERO);


        ExtUser result = CommonUtils.deepClone(extUser);

        System.out.println(JSON.toJSONString(result));

    }
}
