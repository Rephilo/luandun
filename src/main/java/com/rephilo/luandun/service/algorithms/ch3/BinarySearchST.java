package com.rephilo.luandun.service.algorithms.ch3;

import java.util.Iterator;
import java.util.Queue;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;

    private Value[] values;

    private int n;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() {
        return n;
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }

        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            return values[i];
        } else {
            return null;
        }
    }

    public void put(Key key, Value value) {
        int i = rank(key);

        if (i < n && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }

        for (int j = n; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }

        keys[i] = key;
        values[i] = value;

        n++;
    }

    public int rank(Key key) {
        int lo = 0;
        int hi = n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return lo;
    }

    boolean isEmpty() {
        return size() == 0;
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[n - 1];
    }

    public Key select(int k) {
        return keys[k];
    }

    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    public Key floor(Key key) {
        int i = rank(key);
        return keys[i - 1];
    }

    public void delete(Key key) {
        int i = rank(key);
        if (i == n || keys[i].compareTo(key) != 0) {
            return;
        }

        for (int j = n; j > i; j--) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }

        keys[n] = null;
        values[n] = null;
        n--;
    }
}
