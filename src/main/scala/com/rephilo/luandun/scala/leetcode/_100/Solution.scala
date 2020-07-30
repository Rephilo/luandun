package com.rephilo.luandun.scala.leetcode._100

import com.rephilo.luandun.scala.leetcode.datastructure.TreeNode

object Solution {
  /**
   * 尾递归实在写不出来- -
   *
   * @param p
   * @param q
   * @return
   */
  def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
    if (p == null && q == null) {
      return true
    }

    if (p != null && q != null) {
      if (p.value == q.value) {
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
      }
    }
    false
  }
}

