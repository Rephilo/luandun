package com.rephilo.luandun.service.datastructure;

import org.springframework.stereotype.Service;

/**
 * 极简数据结构 第1章
 */
@Service
public class ArrayService {
    /**
     * 对角线问题
     */
    public int[][] diagonal() {
        Integer n = 64;
        int x = 4;
        int y = 2;
        int[][] M = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                M[i][j] = y;
            }
            M[i][i] = x;
            for (int j = i + 1; j < n; j++) {
                M[i][j] = y;
            }
        }

        return M;
    }
}
