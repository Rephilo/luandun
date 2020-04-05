package com.rephilo.luandun.service.leetcode;

import java.util.Arrays;

/**
 * leetcode April challenge
 *
 * @author wangxiao15
 */
public class LeetcodeChallengeService {

    /**
     * 136
     * 常规解法，没考虑空间复杂度
     * 天秀解法，异或
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce((x, y) -> x ^ y).orElse(0);
//        int result = 0;
//        Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
//        for (int num : nums) {
//            tempMap.putIfAbsent(num, 0);
//            tempMap.put(num, tempMap.get(num) + 1);
//        }
//
//        for (Map.Entry<Integer, Integer> entry : tempMap.entrySet()) {
//            if (entry.getValue() < 2) {
//                result = entry.getKey();
//            }
//        }
//
//        return result;
    }

    /**
     * 202
     * 这个题有问题 为什么会收敛到一个循环，无法证明
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        try {
            return duCalc(n, 1);
        } catch (Exception ignored) {

        }
        return false;
    }

    private Boolean duCalc(int m, int times) {
        if (times > 100) {
            return false;
        }
        int result = 0;
        while (m > 0) {
            int i = m % 10;
            result += i * i;
            m = m / 10;
        }

        if (result == 1) {
            return true;
        } else {
            return duCalc(result, times + 1);
        }
    }

    /**
     * 53
     * 不太懂为什么可以转换成直接求和，看问题的角度没找对
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }

    /**
     * 283 想到了双指针，没想到简单的写法
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }
    }

    /**
     * 122 只要后一天比前一天高，就可以按照一天一天的买进
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                max += prices[i] - prices[i - 1];
            }
        }

        return max;
    }


    public int maxProfi2t(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // cash：持有现金
        // hold：持有股票
        // 状态数组
        // 状态转移：cash → hold → cash → hold → cash → hold → cash
        int[] cash = new int[len];
        int[] hold = new int[len];

        cash[0] = 0;
        hold[0] = -prices[0];

        for (int i = 1; i < len; i++) {
            // 这两行调换顺序也是可以的
            cash[i] = Math.max(cash[i - 1], hold[i - 1] + prices[i]);
            hold[i] = Math.max(hold[i - 1], cash[i - 1] - prices[i]);
        }
        return cash[len - 1];
    }


    public static void main(String[] args) {
        int[] param = new int[]{10, 2, 3, 0, 1, 0, 0};
        moveZeroes(param);
        System.out.println(Arrays.toString(param));
    }
}
