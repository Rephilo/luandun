package com.rephilo.luandun.leetcode._028;

/**
 * 028
 *
 * @author rephilo
 */
public class Solution {
    /**
     * 内置方法
     * 最快最省空间，不愧是底层方法，牛逼
     * 可以用但没必要
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr0(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        return haystack.indexOf(needle);
    }

    /**
     * 暴力法
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
     * 暴力法2，和内置方法一样的模式，没有逐个对比而已
     * (双指针法就不写了，虽然我写不出来，但是给我的感觉是手动实现滑动窗口的equals)
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
     * 抄了一遍《算法》的版本，运行时间突破了天际。。
     * 别问奥，看不懂看不懂
     * https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/dong-tai-gui-hua-zhi-kmp-zi-fu-pi-pei-suan-fa
     */
    public static class KMP {
        private String pat;
        private int[][] dfa;

        public KMP(String pat) {
            this.pat = pat;
            int m = pat.length();
            int r = 256;
            dfa = new int[r][m];
            dfa[pat.charAt(0)][0] = 1;
            for (int x = 0, j = 1; j < m; j++) {
                for (int i = 0; i < r; i++) {
                    dfa[i][j] = dfa[i][x];
                }
                dfa[pat.charAt(j)][j] = j + 1;
                x = dfa[pat.charAt(j)][x];
            }
        }

        public int search(String txt) {
            int i, j = txt.length();
            int n = txt.length();
            int m = pat.length();
            for (i = 0, j = 0; i < n && j < m; i++) {
                j = dfa[txt.charAt(i)][j];
            }
            if (j == m) {
                return i - m;
            } else {
                return n;
            }
        }
    }


    public static int strStr3(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        KMP kmp = new KMP(needle);
        int result = kmp.search(haystack);

        return result == haystack.length() ? -1 : result;
    }
}
