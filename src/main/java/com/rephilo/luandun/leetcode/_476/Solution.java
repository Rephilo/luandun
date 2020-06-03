package com.rephilo.luandun.leetcode._476;

public class Solution {
    /**
     * 476
     * 位运算确实是弱项，需要再学习
     *
     * @param num
     * @return
     */
    public int findComplement(int num) {
        int temp = num, c = 0;
        while (temp > 0) {
            //根据判断条件
            //二进制右移并赋值给temp，
            temp >>= 1;
            //二进制左移之后结果+1 赋值给c
            c = (c << 1) + 1;
        }
        return num ^ c;
    }
}
