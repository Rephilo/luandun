package com.rephilo.luandun.leetcode._1232;

public class Solution {
    /**
     * 1232
     * 将求斜率转为求乘积
     * y2-y0/x2-x0 = y1-y0/x1-x0
     *
     * @param coordinates
     * @return
     */
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length < 2) {
            return false;
        }

        if (coordinates.length == 2) {
            return true;
        }

        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        for (int i = 2; i < coordinates.length; i++) {
            int x1 = coordinates[i - 1][0];
            int y1 = coordinates[i - 1][1];
            int x2 = coordinates[i][0];
            int y2 = coordinates[i][1];

            int product1 = (y2 - y0) * (x1 - x0);
            int product2 = (y1 - y0) * (x2 - x0);
            if (product1 != product2) {
                return false;
            }
        }

        return true;
    }
}
