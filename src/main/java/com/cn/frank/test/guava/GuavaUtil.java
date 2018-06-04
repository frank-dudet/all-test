package com.cn.frank.test.guava;

import com.google.common.base.*;
import com.google.common.collect.*;
import com.google.common.io.Files;
import com.google.common.math.BigIntegerMath;
import com.google.common.primitives.Ints;

import java.util.List;
import java.util.Map;

/**
 * Author: frank_du
 * Time : 2017/7/4 下午3:44
 */
public class GuavaUtil {

    public static void main(String[] args) {
        Map<String, Object> map = Maps.newHashMap();
        Optional<Integer> optional = Optional.of(1);
        optional.isPresent();

        Ordering<String> byLengthOrdering = new Ordering<String>() {
            public int compare(String left, String right) {
                return Ints.compare(left.length(), right.length());
            }
        };

        Map<String, String> tmpMap = Maps.newHashMap();
        tmpMap.put("1","test");
        tmpMap.put("2","test2");
        ImmutableMap.copyOf(tmpMap);
        ImmutableMap.builder().putAll(tmpMap).put("3","test3").build();

        List<String> strs = Lists.newArrayList();
        strs.add("1");
        strs.add("2");
        ImmutableList.copyOf(strs.subList(0,1));
        ImmutableList.builder().addAll(strs).add("3").build();

        Joiner joiner = Joiner.on(",").skipNulls();
        System.out.println(joiner.join("Harry", null, "Ron", "Hermione"));

        Splitter.on(",").trimResults().omitEmptyStrings().split("foo,bar,,   qux");

        //去除两端的空格，并把中间的连续空格替换成单个空格
        String spaced = CharMatcher.whitespace().trimAndCollapseFrom("  test   sdsds  sdsd   sdsd  ", ' ');

        Files.getNameWithoutExtension("");

    }

    /**
     * 前置条件
     * @param flag
     * @param errMsg
     * @param args
     */
    public static void checkIsTrue(Boolean flag, String errMsg, String... args) {
        Preconditions.checkArgument(flag, errMsg,args);
    }

    public static <T> T checkNotNull (T t,String errMsg, String... args) {
        return Preconditions.checkNotNull(t, errMsg,args);
    }

    /**
     *  比较相等，即使有null也可以，null与null比较返回true，避免NPE
     * @param o1
     * @param o2
     * @return
     */
    public static boolean equals(Object o1, Object o2) {
        return Objects.equal(o1, o2);
    }

    /**
     * compare链，实现compare方法
     * @return
     */
    public static int compareTo() {
        return ComparisonChain.start().compare("1","1")
                .compare("2", "2")
                .compare("3","4")
                .result();
    }
}
