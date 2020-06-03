package com.rephilo.luandun.leetcode._704;

public class Solution {
    /**
     * 704
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search704(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private static int binarySearch(int[] nums, int start, int end, int target) {
        int mid = (start + end) / 2;
        if (start > end) {
            return -1;
        }
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, end, target);
        } else if (nums[mid] > target) {
            return binarySearch(nums, start, mid - 1, target);
        }

        return -1;
    }

}
