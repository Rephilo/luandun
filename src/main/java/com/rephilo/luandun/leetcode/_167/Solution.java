package com.rephilo.luandun.leetcode._167;

import java.util.HashMap;
import java.util.Map;

/**
 * 167
 *
 * @author rephilo
 */
public class Solution {
    /**
     * 用两层循环没写出来，试试用hashMap
     * 时间复杂度O(n)，空间复杂度O(n)
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum1(int[] numbers, int target) {
        Map<Integer, Integer> tmpMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int calc = target - numbers[i];
            if (tmpMap.get(calc) != null) {
                return new int[]{tmpMap.get(calc), i + 1};
            }
            tmpMap.put(numbers[i], i + 1);
        }

        return new int[]{0, 0};
    }

    /**
     * 强行写循环应该也可以，但是运行时间突破了天际- -
     * 时间复杂度O(n2)，空间复杂度O(1)
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int calc = target - numbers[i];
            for (int j = 0; j < numbers.length; j++) {
                if (i != j) {
                    if (numbers[j] == calc) {
                        return new int[]{i + 1, j + 1};
                    }
                }
            }
        }

        return new int[]{0, 0};
    }

    /**
     * 双指针有点意思，写写看
     * 两端开始求和，如果比当前的数字小，则左指针向右移一位，如果比当前的数字大，则右指针向左移动一位
     * 时间复杂度O(n)，空间复杂度O(1)
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum3(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int tmp = numbers[left] + numbers[right];
            if (tmp == target) {
                return new int[]{left + 1, right + 1};
            } else if (tmp > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{0, 0};
    }
}
