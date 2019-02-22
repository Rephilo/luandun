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
     * @param size            矩阵大小
     * @param commentElement  常规元素
     * @param diagonalElement 对角线元素
     * @return 构成矩阵
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

    /**
     * 二分查找
     *
     * @param key  关键字
     * @param data 查找范围数组
     * @return 查找结果下标
     */
    public int binarySearchArray(int key, int[] data) {
        int size = data.length;
        if (size <= 0) {
            return -1;
        }
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key < data[mid]) {
                high = mid - 1;
            } else if (data[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    /**
     * 3n+1问题
     *
     * @param memory 记忆数组
     * @param num    要处理的数字
     * @return 化简次数
     */
    public int memorizedCollatz(int[] memory, int num) {
        int partResult = 0;
        while (num >= memory.length) {
            num = (num % 2 == 0) ? num / 2 : 3 * num + 1;
            ++partResult;
        }
        if (memory[num] == 0 && num > 0) {
            memory[num] = memorizedCollatz(memory, (num % 2 == 0) ? num / 2 : 3 * num + 1);
        }

        return memory[num] + partResult;
    }
}
