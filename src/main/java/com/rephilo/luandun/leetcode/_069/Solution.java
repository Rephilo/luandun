package com.rephilo.luandun.leetcode._069;

/**
 * 069
 *
 * @author rephilo
 */
public class Solution {
    /**
     * 函数库
     *
     * @param x
     * @return
     */
    private static int mySqrt0(int x) {
        return (int) Math.sqrt(x);
    }

    /**
     * 求平方根，简单点可以用二分查找
     *
     * @param x
     * @return
     */
    private static int mySqrt1(int x) {
        int result = -1;
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long currX = (long) mid * mid;
            if (currX <= x) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    /**
     * 牛顿迭代法
     * 永远滴神
     *
     * @param x
     * @return
     */
    private static int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }
}
