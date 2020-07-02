package com.rephilo.luandun.leetcode._035;

/**
 * 035
 *
 * @author rephilo
 */
public class Solution {
    /**
     * 第一眼想到的是循环，找到位置返回
     * 循环中已经包含了小于全部数字的情况，可以把默认返回值写成num.length处理大于全部数字的情况
     * 时间复杂度O(n)，其实可以改改代码把最好时间复杂度改成O(1)的，不过就是代码不好看
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }

        return nums.length;
    }

    /**
     * 按照查找的想法走，应该还可以用二分查找的方式
     * 速度上没有差距，应该是测试用例的问题，数组太短了
     * 时间复杂度O(Log n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
