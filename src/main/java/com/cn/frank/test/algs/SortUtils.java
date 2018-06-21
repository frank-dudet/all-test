package com.cn.frank.test.algs;

/**
 * Author: frank_du
 * Time : 2018/6/21 下午2:25
 */
public class SortUtils<E extends Comparable<E>> {

    public static void shellSort(int[] list) {
        int length = list.length;
        //希尔排序的初始间隔h
        int h = 1;
        while (h < length / 3) {
            h = h * 3 + 1;
        }

        while (h >= 1) {
            for (int i = h; i < length; i++) {
                int j = i;
                int e = list[j];
                for (;j >= h && isLessThan(e, list[j - h]); j -= h) {
                    list[j] = list[j - h];
                }
                list[j] = e;
            }
            h = h / 3;
        }

        show(list);
    }

    /**
     * 元素比较
     *
     * @param src
     * @param target
     * @return
     */
    private static boolean isLessThan(int src, int target) {
        return src < target;
    }

    /**
     * 打印数组
     *
     * @param list
     */
    private static void show(int[] list) {
        for (int e : list) {
            System.out.print(e + ",");
        }

        System.out.println();
    }
}
