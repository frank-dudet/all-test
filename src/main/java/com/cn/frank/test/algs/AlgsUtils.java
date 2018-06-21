package com.cn.frank.test.algs;

/**
 * Author: frank_du
 * Time : 2018/6/20 上午11:25
 */
public class AlgsUtils {

    /**
     * 计算p, q的最大公约数
     *
     * @param p >=0
     * @param q >=0
     * @return
     */
    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }

        int r = p % q;
        return gcd(q, r);
    }

    /**
     * 判断target是否是素数
     *
     * @param target
     * @return
     */
    public static boolean isPrime(int target) {

        if (target < 2) {
            return false;
        }

        for(int i=2; i * i <= target; i++) {
            if (target % i == 0) {
                return false;
            }
        }
        return true;
    }
}
