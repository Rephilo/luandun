package com.rephilo.luandun.leetcode._014;

public class Solution {
    /**
     * 014
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        for (String str : strs) {
            while (!str.startsWith(pre)) {
                pre = pre.substring(0, pre.length() - 1);
            }
        }

        return pre;
    }
}
