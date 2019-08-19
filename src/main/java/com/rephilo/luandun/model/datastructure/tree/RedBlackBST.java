package com.rephilo.luandun.model.datastructure.tree;

import sun.tools.tree.ShiftLeftExpression;

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
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    /**
     * 节点个数
     */
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.N;
        }
    }

    // 查询
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.value;
        }
        return null;
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
            flipColors(h);
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

    /**
     * 删除最大
     */
    public void deleteMax() {
        if (isNotRed(root.left) && isNotRed(root.right)) {
            root.color = RED;
        }

        root = deleteMax(root);
        if (root != null) {
            root.color = BLACK;
        }
    }

    private Node deleteMax(Node h) {
        if (isRed(h.left)) {
            h = rotateRight(h);
        }

        if (h.right == null) {
            return null;
        }

        if (isNotRed(h.right) && isNotRed(h.right.left)) {
            h = movieRedRight(h);
        }

        return balance(h);
    }

    private Node movieRedRight(Node h) {
        flipColors(h);
        if (isNotRed(h.left.left)) {
            h = rotateRight(h);
        }

        return h;
    }

    public void delete(Key key) {
        if (isNotRed(root.left) && isNotRed(root.right)) {
            root.color = RED;
        }

        root = delete(root, key);
        if (root != null) {
            root.color = BLACK;
        }
    }

    private Node delete(Node h, Key key) {
        if (key.compareTo(h.key) < 0) {
            if (isNotRed(h.left) && isNotRed(h.left.left)) {
                h = movieRedRight(h);
            }

            h.left = delete(h.left, key);
        } else {
            if (isRed(h.left)) {
                h = rotateRight(h);
            }

            if (key.compareTo(h.key) == 0 && h.right == null) {
                return null;
            }

            if (isNotRed(h.right) && isNotRed(h.right.left)) {
                h = movieRedRight(h);
            }

            if (key.compareTo(h.key) == 0) {
                h.value = get(h.right, min(h.right).key);
                h.key = min(h.right).key;
                h.right = deleteMin(h.right);
            } else {
                h.right = delete(h.right, key);
            }
        }

        return balance(h);
    }

    /**
     * 最小值
     *
     * @return
     */
    public Key min() {
        if (root == null) return null;
        return min(root).key;
    }

    private Node min(Node x) {
        assert x != null;
        if (x.left == null) return x;
        else return min(x.left);
    }

}
