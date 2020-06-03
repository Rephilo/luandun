package com.rephilo.luandun.leetcode._844;

public class Solution {
    /**
     * 844
     *
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        StringBuilder s = new StringBuilder();
        StringBuilder t = new StringBuilder();
        for (Character c : S.toCharArray()) {
            if (c.equals('#')) {
                if (s.length() > 0) {
                    s.deleteCharAt(s.length() - 1);
                }
            } else {
                s.append(c);
            }
        }

        for (Character c : T.toCharArray()) {
            if (c.equals('#')) {
                if (t.length() > 0) {
                    t.deleteCharAt(t.length() - 1);
                }
            } else {
                t.append(c);
            }
        }

        return s.toString().equals(t.toString());
    }
}
