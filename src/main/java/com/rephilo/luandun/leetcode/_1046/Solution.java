package com.rephilo.luandun.leetcode._1046;

import java.util.PriorityQueue;

public class Solution {
    /**
     * 1046
     *
     * @param stones
     * @return
     */
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
        for (int i : stones) {
            pq.add(i);
        }
        while (pq.size() >= 2) {

            int x = pq.poll();
            int y = pq.poll();
            if (x > y) {
                pq.offer(x - y);
            }
        }
        return pq.size() == 1 ? pq.peek() : 0;
    }
}
