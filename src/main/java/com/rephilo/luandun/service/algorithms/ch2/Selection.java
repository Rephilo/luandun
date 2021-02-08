package com.rephilo.luandun.service.algorithms.ch2;

import com.rephilo.luandun.service.algorithms.Stopwatch;

import java.util.Random;

/**
 * 选择排序
 *
 * @author rephilo
 */
public class Selection {

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }

            exch(a, i, min);
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
        Selection.sort(a);
        double elapsedTime = timer.elapsedTime();
        System.out.println("user time : " + elapsedTime);
        System.out.println("isSorted : " + isSorted(a));
    }
}
