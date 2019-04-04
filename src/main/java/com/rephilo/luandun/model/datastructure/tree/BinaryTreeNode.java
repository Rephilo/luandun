package com.rephilo.luandun.model.datastructure.tree;

/**
 * 二叉树结点数据结构
 *
 * @author rephilo
 */
public class BinaryTreeNode {
    private int data;

    private BinaryTreeNode left;

    private BinaryTreeNode right;

    private BinaryTreeNode parent;

    public BinaryTreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public BinaryTreeNode getParent() {
        return parent;
    }

    public void setParent(BinaryTreeNode parent) {
        this.parent = parent;
    }
}
