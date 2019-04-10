package com.rephilo.luandun.model.datastructure.tree;


import com.google.common.collect.Queues;

import java.util.List;
import java.util.Queue;

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

    /**
     * 递归添加
     *
     * @param current
     * @param data
     * @return
     */
    private BinaryTreeNode addRecursive(BinaryTreeNode current, int data) {
        if (current == null) {
            return new BinaryTreeNode(data);
        }

        if (data < current.getData()) {
            current.setLeft(addRecursive(current, data));
        } else if (current.getData() < data) {
            current.setRight(addRecursive(current, data));
        } else {
            return current;
        }

        return current;
    }

    /**
     * 插入元素
     *
     * @param data
     */
    public void add(int data) {
        setRoot(addRecursive(getRoot(), data));
    }

    /**
     * 递归查找
     *
     * @param current
     * @param data
     * @return
     */
    private boolean containsNodeRecursive(BinaryTreeNode current, int data) {
        if (current == null) {
            return false;
        }

        if (current.getData() == data) {
            return true;
        }

        return data < current.getData() ?
                containsNodeRecursive(current.getLeft(), data) :
                containsNodeRecursive(current.getRight(), data);
    }

    /**
     * 查找元素
     *
     * @param data
     * @return
     */
    public Boolean containNode(int data) {
        return containsNodeRecursive(root, data);
    }

    /**
     * 找到最小元素
     *
     * @param root
     * @return
     */
    private int findSmallestValue(BinaryTreeNode root) {
        return root.getLeft() == null ? root.getData() : findSmallestValue(root.getLeft());
    }

    /**
     * 递归删除
     *
     * @param current
     * @param data
     * @return
     */
    private BinaryTreeNode deleteRecursive(BinaryTreeNode current, int data) {
        if (current == null) {
            return null;
        }

        if (current.getData() == data) {
            //没有子节点
            if (current.getLeft() == null &&
                    current.getRight() == null) {
                return null;
            }

            //只有一边有节点
            if (current.getRight() == null) {
                return current.getLeft();
            }

            if (current.getLeft() == null) {
                return current.getRight();
            }

            //两个子节点
            int smallestValue = findSmallestValue(current.getRight());
            current.setData(smallestValue);
            current.setRight(deleteRecursive(current.getRight(), smallestValue));
            return current;
        }

        if (data < current.getData()) {
            current.setLeft(deleteRecursive(current.getLeft(), data));
            return current;
        }

        current.setRight(deleteRecursive(current.getRight(), data));
        return current;
    }

    /**
     * 删除元素
     *
     * @param data
     */
    public void delete(int data) {
        root = deleteRecursive(root, data);
    }

    /**
     * 前序遍历
     *
     * @param curr   开始节点
     * @param result 结果数组
     * @return 按照遍历顺序展示结果
     */
    public List<Integer> preOrder(BinaryTreeNode curr, List<Integer> result) {
        if (curr != null) {
            result.add(curr.getData());
            preOrder(curr.getLeft(), result);
            preOrder(curr.getRight(), result);
        }

        return result;
    }

    /**
     * 中序遍历
     *
     * @param curr   开始节点
     * @param result 结果数组
     * @return 按照遍历顺序展示结果
     */
    public List<Integer> inOrder(BinaryTreeNode curr, List<Integer> result) {
        if (curr != null) {
            inOrder(curr.getLeft(), result);
            result.add(curr.getData());
            inOrder(curr.getRight(), result);
        }

        return result;
    }

    /**
     * 后序遍历
     *
     * @param curr   开始节点
     * @param result 结果数组
     * @return 按照遍历顺序展示结果
     */
    public List<Integer> postOrder(BinaryTreeNode curr, List<Integer> result) {
        if (curr != null) {
            postOrder(curr.getLeft(), result);
            postOrder(curr.getRight(), result);
            result.add(curr.getData());
        }

        return result;
    }

    /**
     * 层序遍历
     *
     * @param curr   开始节点
     * @param result 结果数组
     * @return 按照遍历顺序展示结果
     */
    public List<Integer> levelOrder(BinaryTreeNode curr, List<Integer> result) {
        Queue<BinaryTreeNode> queue = Queues.newLinkedBlockingQueue();
        if (curr != null) {
            queue.add(curr);
        }

        while (!queue.isEmpty()) {
            BinaryTreeNode tmp = queue.peek();
            result.add(tmp.getData());

            if (tmp.getLeft() != null) {
                queue.add(tmp.getLeft());
            }

            if (tmp.getRight() != null) {
                queue.add(tmp.getRight());
            }

            queue.poll();
        }

        return result;
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }
}

