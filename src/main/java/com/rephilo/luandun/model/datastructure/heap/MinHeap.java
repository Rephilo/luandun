package com.rephilo.luandun.model.datastructure.heap;

import com.rephilo.luandun.utils.LuandunUtils;

/**
 * 最小堆
 *
 * @author rephilo
 */
public class MinHeap extends Heap {

    public MinHeap(int n) {
        super(n);
    }

    @Override
    public void shiftDown(int index) {
        int i = index;
        int j = leftChild(i);
        int temp = getHeapArray()[i];
        while (j < getCurrentSize()) {
            if (j < getCurrentSize() - 1 && getHeapArray()[j] > getHeapArray()[j + 1]) {
                j++;
            }

            if (temp > getHeapArray()[j]) {
                getHeapArray()[i] = getHeapArray()[j];
                i = j;
                j = leftChild(j);
            } else {
                break;
            }
        }

        getHeapArray()[i] = temp;
    }

    @Override
    public void shiftUp(int index) {
        int tempIndex = index;
        int temp = getHeapArray()[tempIndex];
        while (tempIndex > 0 && getHeapArray()[parent(tempIndex)] > temp) {
            getHeapArray()[tempIndex] = getHeapArray()[parent(tempIndex)];
            tempIndex = parent(tempIndex);
        }

        getHeapArray()[tempIndex] = temp;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= getCurrentSize()) {
            return false;
        }

        int node = getHeapArray()[index];
        int newSize = getCurrentSize() - 1;
        setCurrentSize(newSize);
        getHeapArray()[index] = getHeapArray()[newSize];
        if (getHeapArray()[parent(index)] > getHeapArray()[index]) {
            shiftUp(index);
        } else {
            shiftDown(index);
        }

        return true;
    }

    public int removeMin() {
        if (getCurrentSize() == 0) {
            return 0;
        } else {
            int newSize = getCurrentSize() - 1;
            setCurrentSize(newSize);
            LuandunUtils.swap(getHeapArray(), 0, newSize);
            if (getCurrentSize() > 1) {
                shiftDown(0);
            }
            return getHeapArray()[getCurrentSize()];
        }
    }
}
