package com.rephilo.luandun.service.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode April challenge
 *
 * @author wangxiao15
 */
public class LeetcodeChallengeService {
    /**
     * 1st
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
}
