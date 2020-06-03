package com.rephilo.luandun.leetcode._202;

public class Solution {
    /**
     * 202
     * 这个题有问题 为什么会收敛到一个循环，无法证明
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        try {
            return duCalc(n, 1);
        } catch (Exception ignored) {

        }
        return false;
    }

    private Boolean duCalc(int m, int times) {
        if (times > 100) {
            return false;
        }
        int result = 0;
        while (m > 0) {
            int i = m % 10;
            result += i * i;
            m = m / 10;
        }

        if (result == 1) {
            return true;
        } else {
            return duCalc(result, times + 1);
        }
    }
}
