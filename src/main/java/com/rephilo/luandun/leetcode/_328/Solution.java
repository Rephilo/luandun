package com.rephilo.luandun.leetcode._328;

import com.rephilo.luandun.leetcode.datastructure.ListNode;

public class Solution {
    /**
     * 328
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode oddTail = head;
        ListNode evenHead = head.next;
        ListNode evenTail = evenHead;

        while (evenTail != null && evenTail.next != null) {
            oddTail.next = evenTail.next;
            oddTail = oddTail.next;
            evenTail.next = oddTail.next;
            evenTail = evenTail.next;
        }

        oddTail.next = evenHead;

        return head;
    }
}
