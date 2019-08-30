package com.rephilo.luandun.model.datastructure.graph;


import com.rephilo.luandun.model.datastructure.Bag;

/**
 * 图
 */
public class Graph {
    private int V;
    private int E;
    private Bag<Integer>[] adj;

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {

    }

    public Iterable<Integer> adj(int v) {
        return null;
    }

    public Graph(int v) {
        this.V = v;
        this.E = 0;
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
}
