package com.rephilo.luandun.model.datastructure;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
    private Node first;

    private class Node {
        Item item;
        Node next;
    }

    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    //通过遍历链表使Stack、Queue、Bag变为可迭代的。对于Stack，链表的访问顺序是后进先出；Queue，链表的访问顺序是先进先出；Bag，后进先出顺序，但顺序不重要。
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
