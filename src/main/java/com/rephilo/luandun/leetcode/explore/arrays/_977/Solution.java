package com.rephilo.luandun.leetcode.explore.arrays._977;

import java.util.Arrays;

/**
 * 977
 *
 * @author rephilo
 */
public class Solution {
    /**
     * 给定一个排序好的数组，返回他的平方数组，并且从小到大排序
     * 先平方后做个排序，时间复杂度取决于后面的排序应该是nlogn
     *
     * @param A
     * @return
     */
    public int[] sortedSquares(int[] A) {
        int[] square = new int[A.length];
        if (A.length > 0) {
            for (int i = 0; i < A.length; i++) {
                square[i] = A[i] * A[i];
            }

            Arrays.sort(square);
        }

        return square;
    }

    public int[] sortedSquares1(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j; ) {
            if (A[i] * A[i] > A[j] * A[j]) {
                ans[pos] = A[i] * A[i];
                ++i;
            } else {
                ans[pos] = A[j] * A[j];
                --j;
            }
            --pos;
        }
        return ans;
    }
}
