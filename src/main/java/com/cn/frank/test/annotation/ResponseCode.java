package com.cn.frank.test.annotation;

/**
 * Author: frank_du
 * Time : 2017/4/5 下午7:22
 */
public class ResponseCode extends Code {

    @Display("请求成功")
    public static final int SUCCESS = 200;

    @Display("请求失败")
    public static final int FAILURE = 500;

    @Display("参数错误")
    public static final int PARAM_ERROR = 511;
}
