package com.rephilo.luandun.scala.leetcode._141

import com.rephilo.luandun.scala.leetcode.datastructure.ListNode

import scala.annotation.tailrec

/**
  * 141
  *
  * @author rephilo
  */
object Solution {
  /**
    * 快慢指针法
    *
    * @param head
    * @return
    */
  def hasCycle(head: ListNode): Boolean = {
    if (head == null || head.next == null) {
      return false;
    }

    @tailrec
    def doHasCycle(slow: ListNode, fast: ListNode): Boolean = {
      if (slow == fast) {
        true
      } else {
        if (fast == null || fast.next == null) {
          return false
        }
        doHasCycle(slow.next, fast.next.next)
      }
    }

    doHasCycle(head, head.next)
  }
}
