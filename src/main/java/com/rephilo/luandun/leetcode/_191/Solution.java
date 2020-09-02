package com.rephilo.luandun.leetcode._191;

/**
 * 191
 *
 * @author rephilo
 */
public class Solution {
    /**
     * 将给定的无符号位数字转换为十进制
     * 原生库直接支持转换
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
