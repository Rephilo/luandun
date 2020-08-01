package com.rephilo.luandun.leetcode._104;

import com.rephilo.luandun.leetcode.datastructure.TreeNode;

/**
 * 104
 *
 * @author rephilo
 */
public class Solution {
    /**
     * 树的深度查找，每次+1
     * 时间复杂度O(n)，空间复杂度O(树的深度)
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
