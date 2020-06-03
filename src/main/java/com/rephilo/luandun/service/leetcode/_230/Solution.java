package com.rephilo.luandun.service.leetcode._230;

import com.rephilo.luandun.service.leetcode.datastructure.TreeNode;
import java.util.LinkedList;

public class Solution {
    /**
     * 230
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }
}
