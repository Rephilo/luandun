package com.rephilo.luandun.scala.leetcode._101

import com.rephilo.luandun.scala.leetcode.datastructure.TreeNode

/**
 * 101
 *
 * @author rephilo
 */
object Solution {
  /**
   *
   * @param root
   * @return
   */
  def isSymmetric(root: TreeNode): Boolean = {
    def isMirror(p: TreeNode, q: TreeNode): Boolean = {
      if (p == null && q == null) {
        return true
      }

      if (p != null && q != null) {
        if (p.value == q.value) {
          return isMirror(p.left, q.right) && isMirror(p.right, q.left)
        }
      }
      false
    }

    isMirror(root, root)
  }
}
