package com.rephilo.luandun.service.algorithms.ch2;

import com.rephilo.luandun.service.algorithms.Stopwatch;

import java.util.Random;

public class InsertionX {
    // This class should not be instantiated.
    private InsertionX() {
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        int n = a.length;

        // put smallest element in position to serve as sentinel
        int exchanges = 0;
        for (int i = n - 1; i > 0; i--) {
            if (less(a[i], a[i - 1])) {
                exch(a, i, i - 1);
                exchanges++;
            }
        }
        if (exchanges == 0) return;


        // insertion sort with half-exchanges
        for (int i = 2; i < n; i++) {
            Comparable v = a[i];
            int j = i;
            while (less(v, a[j - 1])) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = v;
        }

        assert isSorted(a);
    }

    protected static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    protected static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    protected static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
        }

        System.out.println();
    }

    protected static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Random random = new Random();
        Double[] a = random.doubles(0.0, 100.0)
                .limit(100000)
                .boxed()
                .toArray(Double[]::new);
        Stopwatch timer = new Stopwatch();
        InsertionX.sort(a);
        double elapsedTime = timer.elapsedTime();
        System.out.println("user time : " + elapsedTime);
        System.out.println("isSorted : " + isSorted(a));
    }
}
