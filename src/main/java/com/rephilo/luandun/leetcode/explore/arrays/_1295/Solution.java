package com.rephilo.luandun.leetcode.explore.arrays._1295;

import java.util.Arrays;

/**
 * 1295
 *
 * @author rephilo
 */
public class Solution {
    /**
     * 除了面向测试用例编程，还有什么更好的检查几位数的办法吗- -
     *
     * @param nums
     * @return
     */
    public int findNumbers(int[] nums) {
        int result = 0;
        if (nums != null && nums.length > 0) {
            for (int num : nums) {
                String str = String.valueOf(num);
                if (str.length() % 2 == 0) {
                    result++;
                }
            }
        }

        return result;
    }

    public int findNumbers0(int[] nums) {
        return (int) Arrays.stream(nums).boxed().filter(x -> x.toString().length() % 2 == 0).count();
    }
}
