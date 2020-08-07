package com.rephilo.luandun.leetcode._125;

/**
 * 125
 *
 * @author rephilo
 */
public class Solution {
    /**
     * 构造一个字符串和他的翻转相同
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s != null && s.length() > 0) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (Character.isLetterOrDigit(c)) {
                    sb.append(c);
                }
            }

            String s1 = sb.toString().toLowerCase();
            String s2 = sb.reverse().toString().toLowerCase();

            return s1.equals(s2);
        }

        return true;
    }
}
