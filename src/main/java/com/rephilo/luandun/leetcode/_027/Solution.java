package com.rephilo.luandun.leetcode._027;

/**
 * 027
 *
 * @author rephilo
 */
public class Solution {
    /**
     * 和26题差不多，同样使用一个指针记录当前的位置，然后找到第一个和输入值不同的值，输入指针的位置，指针+1，最后输出指针位置就是数组长度
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int otherIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[otherIndex] = nums[i];
                otherIndex++;
            }
        }

        return otherIndex;
    }
}
