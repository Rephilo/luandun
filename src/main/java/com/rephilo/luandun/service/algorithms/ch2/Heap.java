package com.rephilo.luandun.service.algorithms.ch2;

import com.rephilo.luandun.service.algorithms.Stopwatch;

import java.util.Random;

public class Heap {
    private Heap() {
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param pq the array to be sorted
     */
    public static void sort(Comparable[] pq) {
        int n = pq.length;

        // heapify phase
        for (int k = n / 2; k >= 1; k--) {
            sink(pq, k, n);
        }

        // sortdown phase
        int k = n;
        while (k > 1) {
            exch(pq, 1, k--);
            sink(pq, 1, k);
        }
    }

    /***************************************************************************
     * Helper functions to restore the heap invariant.
     ***************************************************************************/

    private static void sink(Comparable[] pq, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(pq, j, j + 1)) {
                j++;
            }
            if (!less(pq, k, j)) {
                break;
            }
            exch(pq, k, j);
            k = j;
        }
    }

    /***************************************************************************
     * Helper functions for comparisons and swaps.
     * Indices are "off-by-one" to support 1-based indexing.
     ***************************************************************************/
    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i - 1].compareTo(pq[j - 1]) < 0;
    }

    private static void exch(Object[] pq, int i, int j) {
        Object swap = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = swap;
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    protected static boolean isSorted(Comparable[] a) {
        for (int i = 2; i < a.length; i++) {
            if (less(a, i, i - 1)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Reads in a sequence of strings from standard input; heapsorts them;
     * and prints them to standard output in ascending order.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Random random = new Random();
        Double[] a = random.doubles(0.0, 100.0)
                .limit(100000)
                .boxed()
                .toArray(Double[]::new);
        Stopwatch timer = new Stopwatch();
        Heap.sort(a);
        double elapsedTime = timer.elapsedTime();
        System.out.println("user time : " + elapsedTime);
        System.out.println("isSorted : " + isSorted(a));
    }
}

