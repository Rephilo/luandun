package com.rephilo.luandun.leetcode.datastructure;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 二维矩阵
 *
 * @author rephilo
 */
public class BinaryMatrix {
    private int[][] matrix;

    public int get(int x, int y) {
        return matrix[x][y];
    }

    public List<Integer> dimensions() {
        List<Integer> result = Lists.newArrayList();
        result.add(matrix[0].length);
        result.add(matrix.length);
        return result;
    }

    public BinaryMatrix(int[][] param) {
        this.matrix = param;
    }
}
