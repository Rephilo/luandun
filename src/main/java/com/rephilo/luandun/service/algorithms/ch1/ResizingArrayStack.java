package com.rephilo.luandun.service.algorithms.ch1;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * 可变大小栈 数组实现
 *
 * @author rephilo
 */
public class ResizingArrayStack<T> implements Iterable<T> {
    private T[] a = (T[]) new Object[1];

    private int n = 0;

    public void push(T item) {
        if (n == a.length) {
            resize(2 * a.length);
        }

        a[n++] = item;
    }

    public T pop() {
        T t = a[--n];
        a[n] = null;
        if (n > 0 && n == a.length / 4) {
            resize(a.length / 2);
        }

        return t;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private void resize(int max) {
        T[] temp = (T[]) new Object[max];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }

        a = temp;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    class ReverseArrayIterator implements Iterator<T> {
        private int i = n;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return a[--i];
        }
    }
}
