package com.rephilo.luandun.leetcode._543;

import com.rephilo.luandun.leetcode.datastructure.TreeNode;

public class Solution {
    /**
     * 543
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        return depth(root, 0);
    }

    private int depth(TreeNode currNode, int max) {
        if (currNode == null) {
            return 0;
        }

        int left = depth(currNode.left, max);
        int right = depth(currNode.right, max);
        max = Math.max(left + right, max);

        return Math.max(left, right) + 1;
    }
}
