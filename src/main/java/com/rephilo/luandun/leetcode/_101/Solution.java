package com.rephilo.luandun.leetcode._101;

import com.rephilo.luandun.leetcode.datastructure.TreeNode;

/**
 * 101
 *
 * @author rephilo
 */
public class Solution {
    /**
     * 和100题一致，只不过比较对象换一下
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null) {
            if (p.val == q.val) {
                return isMirror(p.left, q.right) && isMirror(p.right, q.left);
            }
        }

        return false;
    }
}
