package com.rephilo.luandun.leetcode._104;

import com.rephilo.luandun.leetcode.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth1(root.left), maxDepth1(root.right));
    }

    /**
     * 留一个广度优先查找的
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
