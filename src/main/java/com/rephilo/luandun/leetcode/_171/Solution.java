package com.rephilo.luandun.leetcode._171;

/**
 * 171
 *
 * @author rephilo
 */
public class Solution {
    /**
     * 168的反向过程
     *
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }
}
