package com.rephilo.luandun.service.leetcode._20200421;

import com.rephilo.luandun.service.leetcode.datastructure.BinaryMatrix;

import java.util.List;

public class Solution {
    /**
     * 2020 April 21st
     * 从矩阵的右上角设置指针，如果是1则想左移动，如果是0则向下移动，记录最左侧的数据
     *
     * @param binaryMatrix
     * @return
     */
    public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        if (binaryMatrix == null || binaryMatrix.dimensions().isEmpty()) {
            return -1;
        }
        List<Integer> dimensions = binaryMatrix.dimensions();
        int row = dimensions.get(0);
        int col = dimensions.get(1);
        int currRow = 0;
        int currCol = col - 1;
        int result = -1;

        while (currCol >= 0 && currRow < row) {
            if (result == 0) {
                break;
            }
            if (binaryMatrix.get(currRow, currCol) == 0) {
                currRow++;
            } else {
                result = currCol;
                currCol--;
            }
        }

        return result;
    }
}
