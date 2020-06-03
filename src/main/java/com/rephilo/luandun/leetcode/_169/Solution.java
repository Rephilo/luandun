package com.rephilo.luandun.leetcode._169;

public class Solution {
    /**
     * 169
     * 摩尔投票法
     * （拉出来中路solo，剩下的一定是大于n/2的数）
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
//        int size = nums.length;
//        int max = -1;
//        Map<Integer, Integer> countMap = new HashMap<>();
//        Arrays.stream(nums).forEach(x -> {
//            countMap.putIfAbsent(x, 0);
//            countMap.put(x, countMap.get(x) + 1);
//        });
//
//        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
//            if (entry.getValue() >= size / 2) {
//                if (countMap.get(max) == null) {
//                    max = entry.getKey();
//                } else {
//                    if (countMap.get(max) < entry.getValue()) {
//                        max = entry.getKey();
//                    }
//                }
//
//            }
//        }
//
//        return max;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int major = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                major = num;
                count = 1;
            } else {
                if (num == major) {
                    count += 1;
                } else {
                    count -= 1;
                }
            }
        }

        return major;
    }
}
