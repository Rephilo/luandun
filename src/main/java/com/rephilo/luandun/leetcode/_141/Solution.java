package com.rephilo.luandun.leetcode._141;

import com.rephilo.luandun.leetcode.datastructure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 141
 *
 * @author wangxiao15
 */
public class Solution {
    /**
     * 判断循环链表，给了个最简单的set方案
     * 时间复杂度O(n)，空间复杂度O(n)
     *
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> tmpSet = new HashSet<>();
        while (head != null) {
            if (tmpSet.contains(head)) {
                return true;
            } else {
                tmpSet.add(head);
            }

            head = head.next;
        }

        return false;
    }

    /**
     * 之前还学了快慢指针，写写看
     * 时间复杂度O(n)，空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
