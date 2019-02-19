package com.rephilo.luandun.service.datastructure;

import org.springframework.stereotype.Service;

/**
 * 极简数据结构 第1章
 *
 * @author rephilo
 */
@Service
public class ArrayService {

    /**
     * 对角线问题
     *
     * @param size 矩阵大小
     * @param commentElement    常规元素
     * @param diagonalElement   对角线元素
     * @return
     */
    public int[][] diagonal(Integer size, Integer commentElement, Integer diagonalElement) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                matrix[i][j] = diagonalElement;
            }
            matrix[i][i] = commentElement;
            for (int j = i + 1; j < size; j++) {
                matrix[i][j] = diagonalElement;
            }
        }

        return matrix;
    }
}
