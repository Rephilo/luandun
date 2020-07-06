package com.rephilo.luandun.leetcode._058;

/**
 * 058
 *
 * @author rephilo
 */
public class Solution {
    /**
     * 不知道这个题要干什么，但是先用split试一下
     *
     * @param s
     * @return
     */
    public static int lengthOfLastWord1(String s) {
        if (s == null || s.length() == 0 || " ".equals(s)) {
            return 0;
        }
        String[] words = s.split(" ");
        if (words.length > 0) {
            return words[words.length - 1].length();
        }

        return 0;
    }

    /**
     * indexOf没写出来，用循环试试
     *
     * @param s
     * @return
     */
    public static int lengthOfLastWord2(String s) {
        int result = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                result++;
            }

            if (s.charAt(i) == ' ' && result > 0) {
                break;
            }
        }

        return result;
    }
}
