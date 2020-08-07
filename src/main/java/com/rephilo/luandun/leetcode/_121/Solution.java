package com.rephilo.luandun.leetcode._121;

/**
 * 121
 *
 * @author rephilo
 */
public class Solution {
    /**
     * 记录数组中的最小值，然后循环向后计算最大的收益值
     * 时间复杂度O(n)，空间复杂度O(1)
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length > 1) {
            int pre = prices[0];
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > pre) {
                    profit = Math.max(profit, prices[i] - pre);
                } else {
                    pre = prices[i];
                }
            }
        }
        return profit;
    }
}
