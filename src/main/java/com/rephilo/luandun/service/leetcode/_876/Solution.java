package com.rephilo.luandun.service.leetcode._876;

import com.rephilo.luandun.service.leetcode.datastructure.ListNode;

public class Solution {
    /**
     * 876
     *
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        int i = 0;
        int j = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            i++;
        }

        int val = i / 2;

        while (j < val) {
            head = head.next;
            j++;
        }

        return head;
    }
}
