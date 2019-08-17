package com.rephilo.luandun.model.datastructure.tree;

/**
 * 红黑树
 *
 * @param <Key>
 * @param <Value>
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        Key key;
        Value value;
        Node left, right;
        int N;
        boolean color;

        public Node(Key key, Value value, int n, boolean color) {
            this.key = key;
            this.value = value;
            N = n;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }

        return x.color == RED;
    }

    private boolean isNotRed(Node x) {
        return !isRed(x);
    }

    /**
     * 左旋转
     *
     * @param h
     * @return
     */
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    /**
     * 右旋转
     *
     * @param h
     * @return
     */
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    /**
     * 转换颜色
     *
     * @param h
     */
    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private void flipColorsForDelete(Node h) {
        h.color = BLACK;
        h.left.color = RED;
        h.right.color = RED;
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.N;
        }
    }

    /**
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value value) {
        if (h == null) {
            return new Node(key, value, 1, RED);
        }

        int temp = key.compareTo(h.key);
        if (temp < 0) {
            h.left = put(h.left, key, value);
        } else if (temp > 0) {
            h.right = put(h.right, key, value);
        } else {
            h.value = value;
        }

        if (isRed(h.right) && isNotRed(h.left)) {
            h = rotateLeft(h);
        }

        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }

        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    private Node balance(Node h) {
        if (isRed(h.right)) {
            h = rotateLeft(h);
        }
        if (isRed(h.right) && isNotRed(h.left)) {
            h = rotateLeft(h);
        }

        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }

        if (isRed(h.left) && isRed(h.right)) {
            flipColorsForDelete(h);
        }

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    /**
     * 删除最小
     */
    public void deleteMin() {
        if (isNotRed(root.left) && isNotRed(root.right)) {
            root.color = RED;
        }

        root = deleteMin(root);
        if (root != null) {
            root.color = BLACK;
        }
    }

    private Node deleteMin(Node h) {
        if (h.left == null) {
            return null;
        }
        if (isNotRed(h.left) && isNotRed(h.left.left)) {
            h = moveRedLeft(h);
        }

        h.left = deleteMin(h.left);

        return balance(h);
    }

    private Node moveRedLeft(Node h) {
        flipColors(h);
        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
        }

        return h;
    }
}
