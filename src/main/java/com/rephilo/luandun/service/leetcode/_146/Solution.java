package com.rephilo.luandun.service.leetcode._146;

import com.rephilo.luandun.service.leetcode.datastructure.ListNode;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    /**
     * 146
     */
    static class LRUCache {
        private Map<Integer, Integer> cacheMap;
        private final int capacity;
        private ListNode head;
        private ListNode tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cacheMap = new LinkedHashMap<>(capacity);
        }

        public int get(int key) {
            if (!cacheMap.containsKey(key)) {
                return -1;
            }

            Integer val = cacheMap.remove(key);
            cacheMap.put(key, val);
            return val;
        }

        public void put(int key, int value) {
            if (cacheMap.containsKey(key)) {
                cacheMap.remove(key);
                cacheMap.put(key, value);
                return;
            }
            cacheMap.put(key, value);
            //超出capacity，删除最久没用的,利用迭代器，删除第一个
            if (cacheMap.size() > capacity) {
                cacheMap.remove(cacheMap.entrySet().iterator().next().getKey());
            }
        }
    }
}
