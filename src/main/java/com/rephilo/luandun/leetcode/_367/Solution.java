package com.rephilo.luandun.leetcode._367;

public class Solution {
    /**
     * 367
     * 牛顿迭代法
     * 看不懂看不懂，等后面总结一波
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }

        long x = num / 2;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return (x * x == num);
    }
}
