package com.rephilo.luandun.model.datastructure.graph;


import com.rephilo.luandun.model.datastructure.Bag;

import java.io.DataInput;
import java.io.IOException;


/**
 * 图
 *
 * @author rephilo
 */
public class Graph {
    private int V;
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[this.V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public Graph(DataInput in) throws IOException {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    private void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(V() + " vertices, " + E() + " edges\n");
        for (int v = 0; v < V(); v++) {
            s.append(v).append(": ");
            for (int w : this.adj(v)) {
                s.append(w).append(" ");
            }

            s.append("\n");
        }

        return s.toString();
    }

    /**
     * 计算v的度
     *
     * @param v
     * @return
     */
    private int degree(int v) {
        int degree = 0;
        for (int w : this.adj(v)) {
            degree++;
        }

        return degree;
    }

    /**
     * 计算所有顶点最大度
     *
     * @return
     */
    public int masDegree() {
        int max = 0;

        for (int v = 0; v < this.V(); v++) {
            if (degree(v) > max) {
                max = degree(v);
            }
        }

        return max;
    }

    /**
     * 计算所有订单的平均度数
     *
     * @return
     */
    public double avgDegree() {
        return 2.0 * this.E() / this.V();
    }

    /**
     * 计算自环的个数
     *
     * @return
     */
    public int numberOfSelfLoops() {
        int count = 0;
        for (int v = 0; v < this.V(); v++) {
            for (int w : this.adj(v)) {
                if (v == w) {
                    count++;
                }
            }
        }

        return count / 2;
    }
}
