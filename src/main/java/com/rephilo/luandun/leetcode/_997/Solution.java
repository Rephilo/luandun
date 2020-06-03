package com.rephilo.luandun.leetcode._997;

public class Solution {
    /**
     * 997
     *
     * @param N
     * @param trust
     * @return
     */
    public static int findJudge(int N, int[][] trust) {
        if (trust == null || trust.length == 0) {
            return N;
        }
        if (trust.length == 1) {
            return trust[0][1];
        }
        int[] deped = new int[N + 1];
        int[] dep = new int[N + 1];

        for (int[] arr : trust) {
            deped[arr[1]]++;
            dep[arr[0]]++;
        }

        for (int i = 0; i <= N; i++) {
            if (deped[i] == N - 1 && dep[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}
