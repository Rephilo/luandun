package com.rephilo.luandun.service.leetcode._678;

public class Solution {
    /**
     * 678
     * 贪心算法，检查左右是否匹配，将*处理成边界值，如果最终的结果区间包含0则返回true
     *
     * @param s
     * @return
     */
    public boolean checkValidString(String s) {
        int minOpen = 0, maxOpen = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else {
                minOpen--;
                maxOpen++;
            }
            if (maxOpen < 0) {
                return false;
            }
            minOpen = Math.max(minOpen, 0);
        }
        return minOpen == 0;
    }
}
