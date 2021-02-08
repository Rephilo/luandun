package com.rephilo.luandun.service.algorithms.ch2;

import com.rephilo.luandun.service.algorithms.Stopwatch;

import java.util.Random;

/**
 * @author rephilo
 */
public class Quick {
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }

    private static int partition(Comparable[] a, int low, int high) {
        int i = low;
        int j = high + 1;
        Comparable v = a[low];
        while (true) {
            while (less(a[++i], v)) {
                if (i == high) {
                    break;
                }
            }

            // find item on hi to swap
            while (less(v, a[--j])) {
                if (j == low) break;
            }

            // check if pointers cross
            if (i >= j) {
                break;
            }

            exch(a, i, j);
        }

        exch(a, low, j);
        return j;
    }

    protected static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    protected static boolean bigger(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
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
        Quick.sort(a);
        double elapsedTime = timer.elapsedTime();
        System.out.println("user time : " + elapsedTime);
        System.out.println("isSorted : " + isSorted(a));
    }
}
