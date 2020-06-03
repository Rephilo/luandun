package com.rephilo.luandun.service.leetcode._124;

import com.rephilo.luandun.service.leetcode.datastructure.TreeNode;

public class Solution {
    /**
     * 124
     *
     * @param root
     * @return
     */
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxPathSum(root);
        return max;
    }

    public int getMaxPathSum(TreeNode currNode) {
        if (currNode == null) {
            return 0;
        }

        int tmp = currNode.val;
        int left = Math.max(getMaxPathSum(currNode.left), 0);
        int right = Math.max(getMaxPathSum(currNode.right), 0);

        max = Math.max(max, tmp + left + right);

        return currNode.val + Math.max(left, right);
    }
}
