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
     * 深度优先前序遍历
     *
     * @param root
     */
    public void preOrder(BinaryTreeNode root) {
        if (root != null) {
            visit(root);
            preOrder(root.getLeftChild());
            preOrder(root.getRightChild());
        }
    }

    /**
     * 深度优先中序遍历
     *
     * @param root
     */
    public void inOrder(BinaryTreeNode root) {
        if (root != null) {
            inOrder(root.getLeftChild());
            visit(root);
            inOrder(root.getRightChild());
        }
    }

    /**
     * 深度优先后序遍历
     *
     * @param root
     */
    public void postOrder(BinaryTreeNode root) {
        if (root != null) {
            postOrder(root.getLeftChild());
            postOrder(root.getRightChild());
            visit(root);
        }
    }

    /**
     * 广度优先遍历
     *
     * @param root
     */
    public abstract void levelOrder(BinaryTreeNode root);
//    public abstract void CreateTree(T info, BinaryTree leftTree, BinaryTree rightTree);

    public BinaryTreeNode visit(BinaryTreeNode root) {
        return getRoot();
    }
}
