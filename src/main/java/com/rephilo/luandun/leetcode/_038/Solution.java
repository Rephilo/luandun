package com.rephilo.luandun.leetcode._038;

/**
 * 038
 *
 * @author rephilo
 */
public class Solution {
    /**
     * 对上一次的结果的统计输出
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        return count("1", 0, n);
    }

    /**
     * @param str  要计算的字符串
     * @param curr 当前计算次数
     * @param n    目标次数
     * @return
     */
    private String count(String str, int curr, int n) {
        if (curr >= n) {
            return str;
        } else {
            return count(say(str), curr + 1, n);
        }
    }

    /**
     * @param str
     */
    private String say(String str) {
        char[] chars = str.toCharArray();
        char currNum = chars[0];
        int currCount = 1;
        StringBuilder stb = new StringBuilder();
        if (chars.length > 1) {
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == currNum) {
                    currCount++;
                } else {
                    stb.append(currCount).append(currNum);
                    currNum = chars[i];
                    currCount = 1;
                }
            }
        }

        stb.append(currCount).append(currNum);

        return stb.toString();
    }
}
