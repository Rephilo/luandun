package com.rephilo.luandun.leetcode._278;

public class Solution {
    /**
     * 278
     *
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isBadVersion(int n) {
        return false;
    }
}
