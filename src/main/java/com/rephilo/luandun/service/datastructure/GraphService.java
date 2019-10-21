package com.rephilo.luandun.service.datastructure;

import com.google.common.collect.Queues;
import com.rephilo.luandun.model.datastructure.graph.Graph;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

/**
 * @author rephilo
 */
@Service
public class GraphService {

    /**
     * 计算v的度数
     *
     * @param G
     * @param v
     * @return
     */
    public int degree(Graph G, int v) {
        int degree = 0;
        for (int w : G.adj(v)) {
            degree++;
        }

        return degree;
    }

    /**
     * 计算所有顶点最大度数
     *
     * @param G
     * @return
     */
    public int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.V(); v++) {
            if (degree(G, v) > max) {
                max = degree(G, v);
            }
        }

        return max;
    }

    /**
     * 计算所有顶点的平均度数
     *
     * @param G
     * @return
     */
    public double avgDegree(Graph G) {
        return 2.0 * G.E() / G.V();
    }

    /**
     * 计算自环个数
     *
     * @param G
     * @return
     */
    public int numberOfSelfLoops(Graph G) {
        int count = 0;
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (v == w) {
                    count++;
                }
            }
        }

        return count / 2;
    }

    /**
     * 图的深度优先遍历
     *
     * @param G
     * @param s
     */
    public void depthFirstSearch(Graph G, int s) {
        boolean[] marked = new boolean[G.V()];
        int[] edgeTo = new int[G.V()];

        dfs(G, s, marked, edgeTo);
    }

    private void dfs(Graph G, int v, boolean[] marked, int[] edgeTo) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w, marked, edgeTo);
            }
        }
    }

    public void breadFirstSearch(Graph G, int s) {
        boolean[] marked = new boolean[G.V()];
        int[] edgeTo = new int[G.V()];

        bfs(G, s, marked, edgeTo);
    }

    private void bfs(Graph G, int s, boolean[] marked, int[] edgeTo) {
        Queue<Integer> queue = Queues.newLinkedBlockingQueue();
        marked[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.add(w);
                }
            }
        }
    }

    /**
     * 深度优先查找图中的路径
     *
     * @param G
     * @param s
     */
    public Iterable<Integer> depthFirstPaths(Graph G, int s, int v) {
        boolean[] marked = new boolean[G.V()];
        int[] edgeTo = new int[G.V()];

        dfs(G, s, marked, edgeTo);

        return pathTo(v, marked, edgeTo, s);
    }

    private boolean hasPathTo(int v, boolean[] marked) {
        return marked[v];
    }

    private Iterable<Integer> pathTo(int v, boolean[] marked, int[] edgeTo, int s) {
        if (!hasPathTo(v, marked)) {
            return null;
        }

        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }

        path.push(s);

        return path;
    }
}
