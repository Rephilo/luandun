package com.rephilo.luandun.service.leetcode._1008;

import com.rephilo.luandun.service.leetcode.datastructure.TreeNode;

public class Solution {
    /**
     * 1008
     *
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        return buildBstFromPreorder(preorder, 0, preorder.length - 1);
    }

    /**
     * 根据前序遍历的顺序构造二叉搜索树
     *
     * @param preorder
     * @return
     */
    private TreeNode buildBstFromPreorder(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[start]);
        int i;
        for (i = start; i <= end; i++) {
            if (preorder[i] > node.val) {
                break;
            }
        }

        node.left = buildBstFromPreorder(preorder, start + 1, i - 1);
        node.right = buildBstFromPreorder(preorder, i, end);

        return node;
    }
}
