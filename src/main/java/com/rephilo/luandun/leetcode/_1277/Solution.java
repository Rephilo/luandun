package com.rephilo.luandun.leetcode._1277;

public class Solution {
    /**
     * 1277
     *
     * @param matrix
     * @return
     */
    public int countSquares(int[][] matrix) {
        int result = 0;
        int[][] dp = new int[matrix.length][matrix[0].length]; // 直接用matrix初始化就是对的值

        for (int m = 0; m < matrix.length; m++) {
            for (int n = 0; n < matrix[0].length; n++) {
                if (matrix[m][n] == 1) {
                    if (m > 0 && n > 0) {//这里多加个判断，false其实就是相当于之前的那两个循环
                        dp[m][n] = Math.min(Math.min(dp[m - 1][n], dp[m][n - 1]), dp[m - 1][n - 1]) + 1;
                    }
                    result += dp[m][n];
                }
            }
        }
        return result;
    }
}
