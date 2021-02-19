package com.rephilo.luandun.service.algorithms.ch3;

/**
 * 红黑树
 *
 * @author rephilo
 */
public class RedBlackST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;

    private static final boolean BLACK = false;

    private class Node {
        private Key key;
        private Value val;
        private Node left;
        private Node right;
        private int n;
        private boolean color;

        public Node(Key key, Value val, int n, boolean color) {
            this.key = key;
            this.val = val;
            this.n = n;
            this.color = color;
        }
    }

    private Node root;

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }

        return x.n;
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }

        return x.color == RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.n = h.n;
        h.n = 1 + size(h.left) + size(h.right);

        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.n = h.n;
        h.n = 1 + size(h.left) + size(h.right);

        return x;
    }
}
