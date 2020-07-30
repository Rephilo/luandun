package com.rephilo.luandun.leetcode._100;

import com.rephilo.luandun.leetcode.datastructure.TreeNode;

/**
 * 100
 *
 * @author rephilo
 */
public class Solution {
    /**
     * 验证两棵树是一样的，想到先序遍历方式，然后对比结果
     * 时间复杂度O(n), 最优情况（完全平衡二叉树）时为 O(log(N))，最坏情况下（完全不平衡二叉树）时为 O(N)，用于维护递归栈。
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null) {
            if (p.val == q.val) {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }

        return false;
    }
}
