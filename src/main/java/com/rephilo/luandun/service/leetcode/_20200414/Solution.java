package com.rephilo.luandun.service.leetcode._20200414;

public class Solution {
    /**
     * 2020 April 14th
     *
     * @param s
     * @param shift
     * @return
     */
    public static String stringShift(String s, int[][] shift) {
        int finalDirect = 0;
        int finalPath = 0;

        for (int i = 0; i < shift.length; i++) {
            int direct = shift[i][0];
            int path = shift[i][1];
            if (direct == 0) {
                finalPath += path;
            } else {
                finalPath -= path;
            }
        }

        if (finalPath < 0) {
            finalDirect = 1;
            finalPath = Math.abs(finalPath);
        }

        finalPath = finalPath % s.length();

        char[] newCharArray = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int cover = i;
            if (finalDirect == 0) {
                cover += finalPath;
            } else {
                cover -= finalPath;
            }

            if (cover >= s.length()) {
                cover -= s.length();
            } else if (cover < 0) {
                cover += s.length();
            }

            newCharArray[i] = s.charAt(cover);
        }

        return new String(newCharArray);
    }
}
