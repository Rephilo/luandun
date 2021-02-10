package com.rephilo.luandun.service.algorithms.ch2;

/**
 * 优先队列
 *
 * @author rephilo
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;

    private int n = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public MaxPQ(Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++)
            pq[i + 1] = keys[i];
        for (int k = n / 2; k >= 1; k--) {
            sink(k);
        }
        assert isMaxHeap();
    }

    public void insert(Key v) {
        pq[++n] = v;
        swim(n);
    }

    public Key max() {
        if (!isEmpty()) {
            return pq[1];
        }

        return null;
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, n);
        n = n - 1;
        pq[n + 1] = null;
        sink(1);
        return max;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private boolean bigger(int i, int j) {
        return !less(i, j);
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k < n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) {
                j++;
            }

            if (bigger(k, j)) {
                break;
            }

            exch(k, j);
            k = j;
        }
    }

    private boolean isMaxHeap() {
        for (int i = 1; i <= n; i++) {
            if (pq[i] == null) {
                return false;
            }
        }
        for (int i = n + 1; i < pq.length; i++) {
            if (pq[i] != null) {
                return false;
            }
        }
        if (pq[0] != null) {
            return false;
        }
        return isMaxHeapOrdered(1);
    }

    // is subtree of pq[1..n] rooted at k a max heap?
    private boolean isMaxHeapOrdered(int k) {
        if (k > n) {
            return true;
        }
        int left = 2 * k;
        int right = 2 * k + 1;
        if (left <= n && less(k, left)) {
            return false;
        }
        if (right <= n && less(k, right)) {
            return false;
        }
        return isMaxHeapOrdered(left) && isMaxHeapOrdered(right);
    }
}
