package com.rephilo.luandun.executor;

import java.util.concurrent.ForkJoinPool;

/**
 * forkJoin线程池
 *
 * @author rephilo
 */
public class ForkJoinPoolUtils {
    private static ForkJoinPoolUtils Instance = new ForkJoinPoolUtils();

    public static ForkJoinPoolUtils getInstance() {
        return Instance;
    }

    private ForkJoinPool taskPool = null;

    private ForkJoinPoolUtils() {
        init();
    }

    private void init() {
        taskPool = new ForkJoinPool();
    }

    public ForkJoinPool getTaskPool() {
        return taskPool;
    }
}

