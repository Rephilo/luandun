package com.rephilo.luandun.service.leetcode._033;

public class Solution {
    /**
     * 033
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search33(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int boundIndex = findBoundIndex(nums, 0, nums.length - 1);
        if (boundIndex <= 0) {
            return binarySearch(nums, 0, nums.length - 1, target);
        } else if (nums[boundIndex] == target) {
            return boundIndex;
        } else if (nums[0] > target) {
            return binarySearch(nums, boundIndex, nums.length - 1, target);
        } else {
            return binarySearch(nums, 0, boundIndex - 1, target);
        }
    }

    /**
     * 寻找轴值
     *
     * @param nums
     * @return
     */
    public static int findBoundIndex(int[] nums, int left, int right) {
        if (left == right) {
            return -1;
        }
        int mid = (left + right) / 2;

        //最左边情况
        if (mid == 0) {
            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            } else {
                return -1;
            }
        }

        //最右边情况
        if (mid == nums.length - 1) {
            if (nums[mid - 1] > nums[mid]) {
                return mid;
            } else {
                return -1;
            }
        }

        //找到部分顺序队列
        if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
            int l = findBoundIndex(nums, left, mid);
            int r = findBoundIndex(nums, mid + 1, right);

            return Math.max(l, r);
        } else {
            if (nums[mid] > nums[mid - 1]) {
                return mid + 1;
            } else {
                return mid;
            }
        }
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
