package com.rephilo.luandun.leetcode._20200428;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class Solution {
    /**
     * 2020 April 28th
     */
    static class FirstUnique {

        private LinkedHashMap<Integer, Integer> uniqueMap;
        private Set<Integer> duplicate;

        public FirstUnique(int[] nums) {
            uniqueMap = new LinkedHashMap<>();
            duplicate = new HashSet<>();

            for (int num : nums) {
                handle(num);
            }
        }

        private void handle(int num) {
            //已重复的直接过滤
            if (duplicate.contains(num)) {
                return;
            }
            //不在唯一表中，则直接加入唯一表
            if (!uniqueMap.containsKey(num)) {
                uniqueMap.put(num, num);
            } else {
                //在唯一表中，则从唯一表中删除，放入重复表
                uniqueMap.remove(num);
                duplicate.add(num);
            }
        }

        public int showFirstUnique() {
            if (uniqueMap.isEmpty()) {
                return -1;
            } else {
                return uniqueMap.entrySet().iterator().next().getKey();
            }
        }

        public void add(int value) {
            handle(value);
        }
    }
}
