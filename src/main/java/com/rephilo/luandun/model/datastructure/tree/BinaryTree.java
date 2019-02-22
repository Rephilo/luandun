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

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    /**
     * 查找
     *
     * @param key
     * @return
     */
    public BinaryTreeNode find(int key) {
        BinaryTreeNode current = root;
        while (current != null) {
            if (key < current.getData()) {
                if (current.getLeft() == null) {
                    return current;
                }

                current = current.getLeft();
            } else if (key > current.getData()) {
                if (current.getRight() == null) {
                    return current;
                }

                current = current.getRight();
            } else {
                return current;
            }
        }

        return null;
    }

    public void put(int value) {
        BinaryTreeNode newNode = new BinaryTreeNode(value);
        if (root == null) {
            root = newNode;
        } else {
            BinaryTreeNode parent = find(value);
            if (value < parent.getData()) {
                parent.setLeft(newNode);
                parent.getLeft().setParent(parent);
            } else {
                parent.setRight(newNode);
                parent.getRight().setParent(parent);

            }
        }
    }

    public boolean remove(int value) {
        BinaryTreeNode temp = find(value);

        if (temp == null || temp.getData() != value) {
            return false;
        }

        if (temp.getRight() == null && temp.getLeft() == null) {
            if (temp == root) {
                setRoot(null);
            } else if (temp.getParent().getData() < temp.getData()) {
                temp.getParent().setRight(null);
            } else {
                temp.getParent().setLeft(null);
            }

            return true;
        } else if (temp.getLeft() != null && temp.getRight() != null) {
            BinaryTreeNode successor = findSuccessor(temp);

            successor.setLeft(temp.getLeft());
            successor.getLeft().setParent(successor);

            if (successor.getRight() != null && successor.getParent() != temp) {
                successor.getRight().setParent(successor.getRight());
                successor.getParent().setLeft(successor.getRight());
                successor.setRight(temp.getRight());
                successor.getRight().setParent(successor);
            }

            if (temp == root) {
                successor.setParent(null);
                root = successor;
                return true;
            } else {
                successor.setParent(temp.getParent());

                if (temp.getParent().getData() < temp.getData()) {
                    temp.getParent().setRight(successor);
                } else {
                    temp.getParent().setLeft(successor);
                }

                return true;
            }
        } else {
            if (temp.getRight() != null) {
                if (temp == root) {
                    setRoot(temp.getRight());
                    return true;
                }

                temp.getRight().setParent(temp.getParent());
                if (temp.getData() < temp.getParent().getData()) {
                    temp.getParent().setLeft(temp.getRight());
                } else {
                    temp.getParent().setRight(temp.getRight());
                }

                return true;
            } else {
                if (temp == root) {
                    root = temp.getLeft();
                    return true;
                }

                temp.getLeft().setParent(temp.getParent());
                if (temp.getData() < temp.getParent().getData()) {
                    temp.getParent().setLeft(temp.getLeft());
                } else {
                    temp.getParent().setRight(temp.getLeft());
                }

                return true;
            }
        }
    }

    private BinaryTreeNode findSuccessor(BinaryTreeNode n) {
        if (n.getRight() == null) {
            return n;
        }

        BinaryTreeNode current = n.getRight();
        BinaryTreeNode parent = n.getRight();
        while (current != null) {
            parent = current;
            current = current.getLeft();
        }

        return parent;
    }
}
