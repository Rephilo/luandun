package com.rephilo.luandun.leetcode.explore.arrays._485;

/**
 * 485
 * explore 1.5
 *
 * @author rephilo
 */
public class Solution {
    /**
     * 遍历找连续的1有几个
     * 限定了数组元素只有0和1，还是比较简单的
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int max = 0;

        if (nums.length == 1) {
            return nums[0];
        }

        for (int num : nums) {
            if (num == 1) {
                result++;
            } else {
                max = Math.max(max, result);
                result = 0;
            }
        }

        return Math.max(max, result);
    }
}
