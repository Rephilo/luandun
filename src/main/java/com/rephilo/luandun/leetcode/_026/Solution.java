package com.rephilo.luandun.leetcode._026;

/**
 * 026
 *
 * @author rephilo
 */
class Solution {
    /**
     * 题本身并不难，需要注意的是，test case是根据返回的长度，来遍历数组输出的，这里就必须要把不重复的值全部排到数组的前面
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int uniqIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqIndex]) {
                uniqIndex++;
                nums[uniqIndex] = nums[i];
            }
        }
        return uniqIndex + 1;
    }
}
