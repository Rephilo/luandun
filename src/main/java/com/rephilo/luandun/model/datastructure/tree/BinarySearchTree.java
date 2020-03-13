package com.rephilo.luandun.model.datastructure.tree;

import com.google.common.collect.Queues;

import java.util.Queue;

/**
 * 二叉搜索树
 *
 * @author rephilo
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private Node root;

    public int size() {
        return size(root);
    }

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            N = n;
        }
    }

    public int getSize() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.N;
        }
    }

    /**
     * 搜索
     *
     * @param key
     * @return
     */
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int temp = key.compareTo(x.key);
        if (temp < 0) {
            return get(x.left, key);
        } else if (temp > 0) {
            return get(x.right, key);
        } else {
            return x.val;
        }
    }

    /**
     * 插入
     */
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) {
            return new Node(key, val, 1);
        }

        int temp = key.compareTo(x.key);
        if (temp < 0) {
            x.left = put(x.left, key, val);
        } else if (temp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val = val;
        }

        x.N = size(x.left) + size(x.right) + 1;

        return x;
    }

    /**
     * 最小
     *
     * @return
     */
    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }

        return min(x.left);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        }

        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int temp = key.compareTo(x.key);
        if (temp == 0) {
            return x;
        }
        if (temp < 0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }

    /**
     * 最大
     *
     * @return
     */
    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) {
            return x;
        }

        return max(x.right);
    }

    /**
     * 找到排名为k的键
     *
     * @param k
     * @return
     */
    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        if (x == null) {
            return null;
        }

        int t = size(x.left);
        if (t > k) {
            return select(x.left, k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }

    /**
     * 找到key对应的的排名
     *
     * @param key
     * @return
     */
    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if (x == null) {
            return 0;
        }

        int temp = key.compareTo(x.key);
        if (temp < 0) {
            return rank(key, x.left);
        } else if (temp > 0) {
            return 1 + size(x.left) + rank(key, x.right);
        } else {
            return size(x.left);
        }
    }

    /**
     * 删除最小的节点
     */
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }

        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;

        return x;
    }

    /**
     * 删除节点
     *
     * @param key
     */
    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int temp = key.compareTo(x.key);
        if (temp < 0) {
            x.left = delete(x.left, key);
        } else if (temp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.right == null) {
                return x.left;
            }

            if (x.left == null) {
                return x.right;
            }

            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }

        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * 范围
     *
     * @return
     */
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    private Iterable<Key> keys(Key low, Key high) {
        Queue<Key> queue = Queues.newLinkedBlockingQueue();
        keys(root, queue, low, high);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key low, Key high) {
        if (x == null) {
            return;
        }

        int compareLo = low.compareTo(x.key);
        int compareHi = high.compareTo(x.key);

        if (compareLo < 0) {
            keys(x.left, queue, low, high);
        }

        if (compareLo <= 0 && compareHi >= 0) {
            queue.add(x.key);
        }

        if (compareHi > 0) {
            keys(x.right, queue, low, high);
        }
    }
}
