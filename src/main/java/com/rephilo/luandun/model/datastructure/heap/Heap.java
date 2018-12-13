package com.rephilo.luandun.model.datastructure.heap;


public abstract class Heap {

    private int[] heapArray;

    private int currentSize;

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public int[] getHeapArray() {
        return heapArray;
    }

    public int getMaxSize() {
        return getHeapArray().length;
    }

    public void buildHeap() {
        for (int i = getCurrentSize() / 2 - 1; i >= 0; i--) {
            shiftDown(i);
        }
    }

    public Heap(int n) {
        if (n <= 0) {
            return;
        }

        setCurrentSize(0);
        heapArray = new int[n];
        buildHeap();
    }

    public boolean isLeaf(int index) {
        return (index >= getCurrentSize() / 2) && (index < getCurrentSize());
    }

    public int leftChild(int index) {
        return 2 * index + 1;
    }

    public int rightChild(int index) {
        return 2 * index + 2;
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    public boolean insert(int newNode) {
        if (getCurrentSize() == getMaxSize()) {
            return false;
        }

        getHeapArray()[getCurrentSize()] = newNode;
        shiftUp(getCurrentSize());
        setCurrentSize(getCurrentSize() + 1);
        return true;
    }

    public abstract void shiftDown(int index);

    public abstract void shiftUp(int index);

    public abstract boolean remove(int index);
}
