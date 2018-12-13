package com.rephilo.luandun.utils;

import com.rephilo.luandun.model.datastructure.tree.BinaryTreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public static <T> boolean isLessThan(BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        if (left.getValue() instanceof Integer &&
                right.getValue() instanceof Integer) {
            return (Integer) left.getValue() < (Integer) right.getValue();
        } else {
            return false;
        }
    }
}
