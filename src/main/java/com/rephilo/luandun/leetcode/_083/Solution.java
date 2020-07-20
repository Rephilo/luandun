package com.rephilo.luandun.leetcode._083;

import com.rephilo.luandun.leetcode.datastructure.ListNode;

/**
 * 083
 *
 * @author rephilo
 */
public class Solution {
    /**
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.val == curr.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
