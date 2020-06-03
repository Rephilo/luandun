package com.rephilo.luandun.service.leetcode._20200430;

import com.rephilo.luandun.service.leetcode.datastructure.TreeNode;

public class Solution {
    /**
     * 2020 April 30th
     *
     * @param root
     * @param arr
     * @return
     */
    public static boolean isValidSequence(TreeNode root, int[] arr) {
        return isValidSequenceDfs(root, arr, 0);
    }

    private static boolean isValidSequenceDfs(TreeNode curr, int[] arr, int i) {
        //i超过数组长度则说明不匹配，直接返回false
        if (i >= arr.length) {
            return false;
        }
        //走到null节点
        if (curr == null) {
            return false;
        }
        //当前节点字符和正在校验的字符不一致则直接返回false
        if (curr.val != arr[i]) {
            return false;
        }
        //当前节点如果是最后一位，则需要是叶子节点
        if (i == arr.length - 1) {
            return curr.left == null && curr.right == null;
        }

        boolean left = isValidSequenceDfs(curr.left, arr, i + 1);
        boolean right = isValidSequenceDfs(curr.right, arr, i + 1);

        return left || right;
    }

}
