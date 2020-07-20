package com.rephilo.luandun.leetcode._070;

/**
 * 070
 *
 * @author rephilo
 */
public class Solution {
    /**
     * 看起来像是动态规划，但是用递归也能写
     * 这种运行会超时，看一下尾递归怎么做
     *
     * @param n
     * @return
     */
    public static int climbStairs0(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return climbStairs0(n - 1) + climbStairs0(n - 2);
        }
    }

    /**
     * 写成尾递归也太快了吧
     *
     * @param n
     * @return
     */
    public static int climbStairs1(int n) {
        return doClimbStairs1(n, 1, 1);
    }

    /**
     * n
     *
     * @param n
     * @param a
     * @param b
     * @return
     */
    public static int doClimbStairs1(int n, int a, int b) {
        if (n <= 1) {
            return b;
        } else {
            return doClimbStairs1(n - 1, b, a + b);
        }
    }

    /**
     * 经典动态规划方案
     * a是f(n-2)，b是f(n-1)，result计算f(n)
     * 时间O(n)
     *
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        int a = 0;
        int b = 0;
        int result = 1;
        for (int i = 1; i <= n; i++) {
            //f(n-2)
            a = b;
            //f(n-1)
            b = result;
            //f(n)
            result = a + b;
        }

        return result;
    }

    /**
     * 用斐波那契数列的通项公式计算
     * 别问奥，抄的
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        double sqrt = Math.sqrt(5);
        return (int) ((Math.pow((1 + sqrt) / 2, n + 1) - Math.pow((1 - sqrt) / 2, n + 1)) / sqrt);
    }
}
