package com.rephilo.luandun.service.algorithms.ch2;

import com.rephilo.luandun.service.algorithms.Stopwatch;

import java.util.Random;

/**
 * 希尔排序
 *
 * @author rephilo
 */
public class Shell {
    public static void sort(Comparable[] a) {
        int n = a.length;
        int h = 1;
        while (h < n / 3) {
            //1,4,13,40,121,364,1093
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }

            h = h / 3;
        }
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
        Shell.sort(a);
        double elapsedTime = timer.elapsedTime();
        System.out.println("user time : " + elapsedTime);
        System.out.println("isSorted : " + isSorted(a));
//        show(a);
    }
}
