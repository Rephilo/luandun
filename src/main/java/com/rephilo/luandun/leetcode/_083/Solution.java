package com.rephilo.luandun.leetcode._083;

import com.rephilo.luandun.leetcode.datastructure.ListNode;

/**
 * 083
 *
 * @author rephilo
 */
public class Solution {
    /**
     * 有序的链表，如果当前值和next值相等，那么直接跳过next节点，
     *
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
