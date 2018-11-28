package com.rephilo.luandun.model.datastructure.tree;

/**
 * 二叉树结点数据结构
 *
 * @param <T>
 * @author rephilo
 */
public class BinaryTreeNode<T> {
    private T value;

    private BinaryTreeNode<T> leftChild;

    private BinaryTreeNode<T> rightChild;

    public BinaryTreeNode() {

    }

    public BinaryTreeNode(T value) {

    }

    public BinaryTreeNode(T value, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

//    public abstract boolean isLeaf();


    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinaryTreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }
}
