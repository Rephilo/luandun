package com.rephilo.luandun.leetcode._189;

/**
 * 189
 *
 * @author rephilo
 */
public class Solution {
    /**
     * 题目要求用O(1)空间复杂度，一上来想不到，先用个数组试试
     * 求余解法好秀啊。。。
     *
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        if (nums != null && nums.length > 0) {
            int[] result = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                result[(i + k) % nums.length] = nums[i];
            }

            System.arraycopy(result, 0, nums, 0, nums.length);
        }
    }

    /**
     * 从第一个开始，看他换到哪个位置，换到的地方的值用tmp记录，之后把换到位置的值放到他应该放的位置，以此循环
     * 这种没怎么看懂代码，不过能知道在做什么
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}
