package com.rephilo.luandun.leetcode._387;

public class Solution {
    /**
     * 387
     *
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
//        int[] arr = new int[26];
//        int result = -1;
//        char[] array = s.toCharArray();
//        for (char c : array) {
//            arr[c - 97] += 1;
//        }
//
//        for (int i = 0; i < array.length; i++) {
//            if (arr[array[i] - 97] == 1) {
//                result = result + i + 1;
//                break;
//            }
//        }
//
//        return result;
        int result = Integer.MAX_VALUE;

        for (char c = 'a'; c <= 'z'; c++) {
            int index = s.indexOf(c);

            if (index != -1 &&
                    index == s.lastIndexOf(c)) {
                result = Math.min(result, index);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
