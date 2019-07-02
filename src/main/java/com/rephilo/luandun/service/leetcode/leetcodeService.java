package com.rephilo.luandun.service.leetcode;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 没事写写LeetCode的题
 *
 * @author wangxiao15
 */
@Service
public class leetcodeService {
    /**
     * 001
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff) && map.get(diff) != i) {
                return new int[]{i, map.get(diff)};
            }
        }

        return new int[2];
    }

    /**
     * 002
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int step = 0;
        ListNode listNode = null;
        ListNode head = null;

        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            int result = val1 + val2;

            if (step > 0) {
                result = result + step;
                step--;
            }

            if (result > 9) {
                result = result - 10;
                step++;
            }

            if (listNode == null) {
                listNode = new ListNode(result);
                head = listNode;
            } else {
                listNode.next = new ListNode(result);
                listNode = listNode.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (step > 0) {
            listNode.next = new ListNode(step);
        }

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
