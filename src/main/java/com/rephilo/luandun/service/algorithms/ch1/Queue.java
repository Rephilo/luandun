package com.rephilo.luandun.service.algorithms.ch1;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * 队列
 * 链表实现
 *
 * @author rephilo
 */
public class Queue<T> implements Iterable<T> {
    private Node first;

    private Node last;

    private int n;

    private class Node {
        T item;
        Node next;
    }

    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }

        n++;
    }

    public T dequeue() {
        T item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        n--;

        return item;
    }

    boolean isEmpty() {
        return first == null;
    }

    int size() {
        return n;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }
}
