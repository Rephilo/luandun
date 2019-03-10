package com.rephilo.luandun.utils;

import com.google.common.collect.Lists;
import com.rephilo.luandun.model.datastructure.tree.BinaryTreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 操作工具包
 *
 * @author rephilo
 */
public class LuandunUtils {

    /**
     * 将数组转换为包装类
     *
     * @param array
     * @return
     */
    public static List<Integer> intArrayboxToList(int[] array) {
        return Arrays.stream(array).boxed().collect(Collectors.toList());
    }

    /**
     * 交换数组中的元素
     *
     * @param array 数组
     * @param idx   i
     * @param idy   j
     * @return
     */
    public static boolean swap(int[] array, int idx, int idy) {
        int swap = array[idx];
        array[idx] = array[idy];
        array[idy] = swap;
        return true;
    }

    /**
     * 按照矩阵格式输出数组
     *
     * @param array
     * @return
     */
    public static List<String> layoutArray(int[][] array) {
        return Arrays.stream(array)
                .map(e -> String.join(",", Arrays.toString(e)))
                .collect(Collectors.toList());
    }

    /**
     * 生成一个迷宫的例子
     *
     * @return
     */
    public static Character[][] getMazeExample() {
        return new Character[][]{
                {'*', '*', '*', '*', '*', '*', '*'},
                {'*', '0', '*', '0', '0', '0', '*'},
                {'*', '0', '*', '0', '*', '0', '*'},
                {'*', '0', '0', '0', '*', '0', '*'},
                {'*', '*', '*', '*', '*', '*', '*'}
        };
    }
}
