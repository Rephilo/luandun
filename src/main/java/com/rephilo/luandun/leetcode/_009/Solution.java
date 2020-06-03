package com.rephilo.luandun.leetcode._009;

public class Solution {
    /**
     * 009
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int reverse = 0;
        int y = x;

        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }

        return y == reverse;
    }
}
