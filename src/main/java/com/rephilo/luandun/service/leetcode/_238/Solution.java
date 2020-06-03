package com.rephilo.luandun.service.leetcode._238;

public class Solution {
    /**
     * 238 左边乘一遍，右边乘一遍
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int left = 1;
        for (int i = 0; i < res.length; i++) {
            res[i] = left;
            left *= nums[i];
        }
        int right = 1;
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
