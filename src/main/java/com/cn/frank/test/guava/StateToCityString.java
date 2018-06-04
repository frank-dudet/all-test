package com.cn.frank.test.guava;

import com.google.common.base.Function;
import com.google.common.base.Joiner;

import javax.annotation.Nullable;

/**
 * Author: frank_du
 * Time : 2017/7/5 上午11:00
 */
public class StateToCityString implements Function<State, String> {
    @Nullable
    public String apply(@Nullable State input) {
        return Joiner.on(",").join(input.getMainCities());
    }
}
