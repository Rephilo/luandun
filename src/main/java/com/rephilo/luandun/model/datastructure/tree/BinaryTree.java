package com.rephilo.luandun.model.datastructure.tree;


/**
 * 二叉树数据结构
 *
 * @author rephilo
 */
public abstract class BinaryTree {
    /**
     * 根节点
     */
    private BinaryTreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    /**
     * 是否为空树
     *
     * @return
     */
    public abstract boolean isEmpty();

    /**
     * 获取根节点
     *
     * @return
     */
    public abstract BinaryTreeNode getRoot();

    /**
     * 获取父节点
     *
     * @param current
     * @return
     */
    public abstract BinaryTreeNode getParent(BinaryTreeNode current);

    /**
     * 获取左兄弟节点
     *
     * @param current
     * @return
     */
    public abstract BinaryTreeNode getLeftSibling(BinaryTreeNode current);

    /**
     * 获取右兄弟节点
     *
     * @param current
     * @return
     */
    public abstract BinaryTreeNode getRightSibling(BinaryTreeNode current);

    /**
     * 前序遍历
     *
     * @param root
     */
    public abstract void preOrder(BinaryTreeNode root);

    /**
     * 中序遍历
     *
     * @param root
     */
    public abstract void inOrder(BinaryTreeNode root);

    /**
     * 后序遍历
     *
     * @param root
     */
    public abstract void postOrder(BinaryTreeNode root);

    /**
     * 层次遍历
     *
     * @param root
     */
    public abstract void levelOrder(BinaryTreeNode root);
//    public abstract void CreateTree(T info, BinaryTree leftTree, BinaryTree rightTree);
}
