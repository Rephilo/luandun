package com.rephilo.luandun.model.datastructure.tree;

/**
 * 二叉树结点数据结构
 *
 * @param <T>
 * @author rephilo
 */
public abstract class BinaryTreeNode<T> {
    private T value;

    public BinaryTreeNode() {

    }

    public BinaryTreeNode(T value) {

    }

    public BinaryTreeNode(T value, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {

    }

    public abstract T getalue();

    public abstract void setValue();

    public abstract BinaryTreeNode<T> getLeftChild();

    public abstract BinaryTreeNode<T> getRightChild();

    public abstract void setLeftChild();

    public abstract void setRightChild();

    public abstract boolean isLeaf();
}
