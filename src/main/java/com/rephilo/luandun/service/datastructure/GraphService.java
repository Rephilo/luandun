package com.rephilo.luandun.service.datastructure;

import com.rephilo.luandun.model.datastructure.graph.Graph;
import org.springframework.stereotype.Service;

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
}
