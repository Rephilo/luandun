package com.rephilo.luandun.model.datastructure.tree;


import com.google.common.collect.Queues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树数据结构
 *
 * @author rephilo
 */
public class BinaryTree {
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
    public boolean isEmpty() {
        return getRoot() == null;
    }

    /**
     * 访问节点
     *
     * @param current
     */
    public void visit(BinaryTreeNode current) {
        System.out.println(root.getValue());
    }

    /**
     * 返回根节点
     *
     * @return
     */
    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    /**
     * 获取父节点(借助栈实现)
     *
     * @param current
     * @return
     */
    public BinaryTreeNode getParent(BinaryTreeNode current) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode pointer = root;
        if (root != null && current != null) {
            while (stack.empty()) {
                if (pointer != null) {
                    if (current == pointer.getLeftChild() || current == pointer.getRightChild()) {
                        return pointer;
                    } else {
                        stack.push(pointer);
                        pointer = pointer.getLeftChild();
                    }
                } else {
                    pointer = stack.peek();
                    stack.pop();
                    pointer = pointer.getRightChild();
                }
            }
        }

        return null;
    }

//    /**
//     * 获取左兄弟节点
//     *
//     * @param current
//     * @return
//     */
//    public abstract BinaryTreeNode getLeftSibling(BinaryTreeNode<T> current);
//
//    /**
//     * 获取右兄弟节点
//     *
//     * @param current
//     * @return
//     */
//    public abstract BinaryTreeNode getRightSibling(BinaryTreeNode<T> current);

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
     * 广度优先遍历(借助队列实现)
     *
     * @param root
     */
    public void levelOrder(BinaryTreeNode root) {
        Queue<BinaryTreeNode> nodeQueue = Queues.newLinkedBlockingQueue();
        BinaryTreeNode currentNode = root;
        if (currentNode != null) {
            nodeQueue.add(currentNode);
        }

        while (!nodeQueue.isEmpty()) {
            currentNode = nodeQueue.poll();
            visit(currentNode);

            if (currentNode.getLeftChild() != null) {
                nodeQueue.add(currentNode.getLeftChild());
            }

            if (currentNode.getRightChild() != null) {
                nodeQueue.add(currentNode.getRightChild());
            }
        }


    }

    /**
     * 创建二叉树
     *
     * @param info
     * @param leftTree
     * @param rightTree
     * @return
     */
    public BinaryTree createTree(int info, BinaryTree leftTree, BinaryTree rightTree) {
        BinaryTree tree = new BinaryTree();
        tree.setRoot(new BinaryTreeNode(info, leftTree.getRoot(), rightTree.getRoot()));
        leftTree.setRoot(null);
        rightTree.setRoot(null);

        return tree;
    }
}
