package com.rephilo.luandun.leetcode._028;

/**
 * 028
 *
 * @author rephilo
 */
public class Solution {
    /**
     * 截取法1
     * 简单方案，用截取字符串的方式进行比较，相比官方答案，这种循环写的像个人
     * 时间复杂度最坏O(nm)，找到了就O((n-m)m)，n是源字符串长度，m是目标字符串长度
     * equals方法默认时间复杂度是O(n)的
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr1(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int j = needle.length();
        for (int i = 0; i < haystack.length(); i++) {
            if (i + j <= haystack.length()) {
                if (haystack.substring(i, i + j).equals(needle)) {
                    return i;
                }
            }
        }

        return -1;
    }

    /**
     * 截取法2
     * 官方版截取字符串的方案，这个循环你不品品，一般人想不到。
     * 循环是从0开始，到源字符串长度-目标字符串长度，为的是防止数组越界，并且可以将循环的次数减少，和 截取法2 的 if i+j<=haystack.length 一个意思
     * 时间复杂度O((n-m)m)
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr2(String haystack, String needle) {
        int i = needle.length();
        int j = haystack.length();

        for (int start = 0; start < j - i + 1; start++) {
            if (haystack.substring(start, start + i).equals(needle)) {
                return start;
            }
        }
        return -1;
    }

    /**
     * KMP
     * 别问奥，看不懂看不懂
     * https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/dong-tai-gui-hua-zhi-kmp-zi-fu-pi-pei-suan-fa
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr3(String haystack, String needle) {

    }
}
