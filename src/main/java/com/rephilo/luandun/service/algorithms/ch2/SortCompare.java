package com.rephilo.luandun.service.algorithms.ch2;


import com.rephilo.luandun.service.algorithms.StdOut;
import com.rephilo.luandun.service.algorithms.StdRandom;
import com.rephilo.luandun.service.algorithms.Stopwatch;

/**
 * @author rephilo
 */
public class SortCompare {
    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) {
            Insertion.sort(a);
        }

        if (alg.equals("Selection")) {
            Selection.sort(a);
        }

        if (alg.equals("Shell")) {
            Shell.sort(a);
        }

        if (alg.equals("Merge")) {
            Merge.sort(a);
        }

        if(alg.equals("Quick")){
            Quick.sort(a);
        }
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int n, int t) {
        double total = 0.0;
        Double[] a = new Double[n];

        for (int i = 0; i < t; i++) {
            for (int j = 0; j < n; j++) {
                a[j] = StdRandom.uniform();
            }
            double time = time(alg, a);
            System.out.println("epoch : " + i);
            total += time;
        }

        return total;
    }

    public static void main(String[] args) {
        String alg1 = "Quick";
        String alg2 = "Merge";
        int n = 100000;
        int t = 100;
        double t1 = timeRandomInput(alg1, n, t);
        double t2 = timeRandomInput(alg2, n, t);
        StdOut.printf("For %d random Doubles\n %s is", n, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
    }
}
