package com.cn.frank.test.guava;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Author: frank_du
 * Time : 2017/7/5 上午11:01
 */
public class FunctionTest {

    public static void main(String[] args) {
        Map<String,State> stateMap= Maps.newHashMap();
        State s=new State("New York");
        s.addCity(new City("new"));
        s.addCity(new City("york"));
        stateMap.put("NY",s);
        Function<String,State> lookup= Functions.forMap(stateMap);
        Function<State,String> stateFunction=new StateToCityString();

        //Function<A, C> compose(Function<B, C> g, Function<A, ? extends B> f)
        //接收两个Function作为参数，返回两个Function的组合
        //f的输出会作为g的输入，g输出为最终作为compose的输出
        Function<String,String> composed=Functions.compose(stateFunction,lookup);
        String str=composed.apply("NY");
        System.out.println(str);
    }
}
