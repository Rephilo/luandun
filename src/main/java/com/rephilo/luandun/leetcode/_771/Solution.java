package com.rephilo.luandun.leetcode._771;

import java.util.HashSet;

public class Solution {
    /**
     * 771
     *
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        int result = 0;
        HashSet<Character> set = new HashSet<>();
        for (char j : J.toCharArray()) {
            set.add(j);
        }

        for (char s : S.toCharArray()) {
            if (set.contains(s)) {
                result++;
            }
        }

        return result;
    }
}
