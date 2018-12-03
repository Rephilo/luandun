package com.rephilo.luandun.model.datastructure.tree;

/**
 * 二叉搜索树
 *
 * @author rephilo
 */
public class BinarySearchTree extends BinaryTree {

    /**
     * 二叉搜索树插入新节点
     *
     * @param root
     * @param newElement
     */
    public void insertNode(BinaryTreeNode root, BinaryTreeNode newElement) {
        BinaryTreeNode currentNode = null;
        if (root == null) {
            BinaryTree tree = new BinarySearchTree();
            tree.setRoot(newElement);
        } else {
            currentNode = root;
            while (currentNode != null) {
                if (newElement.getValue() == currentNode.getValue()) {
                    return;
                } else if (newElement.getValue() < currentNode.getValue()) {
                    if (currentNode.getLeftChild() == null) {
                        currentNode.setLeftChild(newElement);
                        return;
                    } else {
                        currentNode = currentNode.getLeftChild();
                    }
                } else {
                    if (currentNode.getRightChild() == null) {
                        currentNode.setRightChild(newElement);
                        return;
                    } else {
                        currentNode = currentNode.getRightChild();
                    }
                }
            }
        }
    }

    /**
     * 二叉搜索树删除节点
     *
     * @param element
     */
    public void deleteNode(BinaryTreeNode element) {
        if (element == null) {
            return;
        }

        BinaryTreeNode tempPointer;
        BinaryTreeNode tempParent = null;
        BinaryTreeNode parent = getParent(element);

        if (element.getLeftChild() == null) {
            tempPointer = element.getRightChild();
        } else {
            tempPointer = element.getLeftChild();
            while (tempPointer.getRightChild() != null) {
                tempParent = tempPointer;
                tempPointer = tempPointer.getRightChild();
            }

            if (tempParent == null) {
                element.setLeftChild(tempPointer.getLeftChild());
            } else {
                element.setRightChild(tempPointer.getRightChild());
            }

            tempPointer.setLeftChild(element.getLeftChild());
            tempPointer.setRightChild(element.getRightChild());
        }

        if (parent == null) {
            setRoot(tempPointer);
        } else if (parent.getLeftChild() == element) {
            parent.setLeftChild(tempPointer);
        } else {
            parent.setRightChild(tempPointer);
        }
    }
}
