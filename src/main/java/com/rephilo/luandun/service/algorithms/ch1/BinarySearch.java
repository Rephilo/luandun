package com.rephilo.luandun.service.algorithms.ch1;

/**
 * 二分查找
 *
 * @author rephilo
 */
public class BinarySearch {
    /**
     * 普通写法的二分查找
     * 704是写的尾递归方式，讲道理不用那么麻烦
     *
     * @param key
     * @param a
     * @return
     */
    public static int rank(int key, int[] a) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key < a[mid]) {
                high = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
