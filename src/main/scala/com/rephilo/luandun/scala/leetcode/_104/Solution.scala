package com.rephilo.luandun.scala.leetcode._104

import com.rephilo.luandun.scala.leetcode.datastructure.TreeNode

/**
 * 104
 *
 * @author rephilo
 */
object Solution {
  /**
   *
   * @param root
   * @return
   */
  def maxDepth(root: TreeNode): Int = {
    if (root == null) {
      return 0
    }

    1 + math.max(maxDepth(root.left), maxDepth(root.right))
  }
}
