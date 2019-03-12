package com.rephilo.luandun.model.datastructure.tree;

import lombok.Data;

/**
 * 二叉树结点数据结构
 *
 * @author rephilo
 */
@Data
public class BinaryTreeNode {
    private int data;

    private BinaryTreeNode left;

    private BinaryTreeNode right;

    private BinaryTreeNode parent;

    public BinaryTreeNode(int data) {
        this.data = data;
    }
}
