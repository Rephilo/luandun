package com.rephilo.luandun.service.leetcode._993;

import com.rephilo.luandun.service.leetcode.datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * 993
     * 用两个hashMap存，好秀啊。。
     *
     * @param root
     * @param x
     * @param y
     * @return
     */
    private Map<Integer, Integer> depthMap;
    private Map<Integer, TreeNode> parentMap;

    public boolean isCousins(TreeNode root, int x, int y) {
        depthMap = new HashMap<>();
        parentMap = new HashMap<>();
        dfsIsCousins(root, null);
        return depthMap.get(x).equals(depthMap.get(y))
                && !parentMap.get(x).equals(parentMap.get(y));
    }

    private void dfsIsCousins(TreeNode curr, TreeNode parent) {
        if (curr == null) {
            return;
        }
        depthMap.put(curr.val, parent != null ? 1 + depthMap.get(parent.val) : 0);
        parentMap.put(curr.val, parent);
        dfsIsCousins(curr.left, curr);
        dfsIsCousins(curr.right, curr);
    }
}
