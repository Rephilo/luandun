package com.rephilo.luandun.service.sort;

import com.rephilo.luandun.annotation.CountDown;
import com.rephilo.luandun.constant.SortConstant;
import com.rephilo.luandun.model.datastructure.heap.MinHeap;
import com.rephilo.luandun.model.vo.SortResultVO;
import com.rephilo.luandun.utils.LuandunUtils;
import org.springframework.stereotype.Service;

/**
 * 排序实现类
 *
 * @author rephilo
 */
@Service
public class SortService {

    /**
     * 插入排序
     *
     * @param array
     * @return
     */
    @CountDown
    public SortResultVO insertSort(int[] array) {
        SortResultVO resultVO = new SortResultVO();

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = temp;
        }

        resultVO.setResult(array);

        return resultVO;
    }

    /**
     * 希尔排序
     *
     * @param array
     * @return
     */
    @CountDown
    public SortResultVO shellSort(int[] array) {
        SortResultVO resultVO = new SortResultVO();

        int n = array.length;
        for (int delta = n / SortConstant.SHELL_GAP; delta > 0; delta /= SortConstant.SHELL_GAP) {
            for (int i = 0; i < delta; i++) {
                for (int j = i + delta; j < n; j += delta) {
                    if (array[j] < array[j - delta]) {
                        int temp = array[j];
                        int k = j - delta;
                        while (k >= 0 && array[k] > temp) {
                            array[k + delta] = array[k];
                            k -= delta;
                        }
                        array[k + delta] = temp;
                    }
                }
            }
        }
//        for (int delta : SortConstant.MARCIN_CIURA_GAPS) {
//            for (int i = 0; i < delta; i++) {
//                for (int j = i + delta; j < n; j += delta) {
//                    if (array[j] < array[j - delta]) {
//                        int temp = array[j];
//                        int k = j - delta;
//                        while (k >= 0 && array[k] > temp) {
//                            array[k + delta] = array[k];
//                            k -= delta;
//                        }
//                        array[k + delta] = temp;
//                    }
//                }
//            }
//        }

        resultVO.setResult(array);

        return resultVO;
    }

    /**
     * 选择排序
     *
     * @param array
     * @return
     */
    @CountDown
    public SortResultVO selectSort(int[] array) {
        SortResultVO resultVO = new SortResultVO();

        int smallest;
        for (int i = 0; i < array.length - 1; i++) {
            smallest = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[smallest]) {
                    smallest = j;
                }
            }

            LuandunUtils.swap(array, smallest, i);
        }

        resultVO.setResult(array);

        return resultVO;
    }

    /**
     * 堆排序
     *
     * @param array
     * @return
     */
    @CountDown
    public SortResultVO heapSort(int[] array) {
        SortResultVO resultVO = new SortResultVO();
        MinHeap minHeap=new MinHeap(array.length);
        resultVO.setResult(array);

        return resultVO;
    }

    /**
     * 冒泡排序
     *
     * @param array
     * @return
     */
    @CountDown
    public SortResultVO bubbleSort(int[] array) {
        SortResultVO resultVO = new SortResultVO();

        boolean noSwap = true;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    LuandunUtils.swap(array, j, j - 1);
                    noSwap = false;
                }
            }

            if (noSwap) {
                break;
            }
        }

        resultVO.setResult(array);

        return resultVO;
    }

    /**
     * 快速排序
     *
     * @param array
     * @return
     */
    @CountDown
    public SortResultVO quickSort(int[] array) {
        SortResultVO resultVO = new SortResultVO();
        doQuickSort(array, 0, array.length - 1);
        resultVO.setResult(array);

        return resultVO;
    }

    /**
     * 快排实现
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    private void doQuickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = selectPivot(left, right);
        LuandunUtils.swap(array, pivot, right);
        pivot = partition(array, left, right);
        doQuickSort(array, left, pivot - 1);
        doQuickSort(array, pivot + 1, right);
    }

    /**
     * 选择轴值的index
     *
     * @param left  左
     * @param right 右
     * @return
     */
    private int selectPivot(int left, int right) {
        return (left + right) / 2;
    }

    /**
     * 对单个分组的处理
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] array, int left, int right) {
        int l = left;
        int r = right;
        int temp = array[r];

        while (l != r) {
            while (array[l] <= temp && r > l) {
                l++;
            }
            if (l < r) {
                array[r] = array[l];
                r--;
            }

            while (array[r] >= temp && r > l) {
                r--;
            }

            if (l < r) {
                array[l] = array[r];
                l++;
            }
        }
        array[l] = temp;
        return l;
    }

    /**
     * 归并排序
     *
     * @param array
     * @return
     */
    @CountDown
    public SortResultVO mergeSort(int[] array) {
        SortResultVO resultVO = new SortResultVO();
        int[] tempArray = new int[array.length];
        doMergeSort(array, tempArray, 0, array.length - 1);

        resultVO.setResult(array);

        return resultVO;
    }

    /**
     * 递归分组
     *
     * @param array
     * @param tempArray
     * @param left
     * @param right
     */
    private void doMergeSort(int[] array, int[] tempArray, int left, int right) {
        int middle;
        if (left < right) {
            middle = (left + right) / 2;
            doMergeSort(array, tempArray, left, middle);
            doMergeSort(array, tempArray, middle + 1, right);
            mergeResult(array, tempArray, left, right, middle);
        }
    }

    /**
     * 合并分组结果
     *
     * @param array
     * @param tempArray
     * @param left
     * @param right
     * @param middle
     */
    private void mergeResult(int[] array, int[] tempArray, int left, int right, int middle) {
        int i;
        int j;
        int index1;
        int index2;

        for (j = left; j <= right; j++) {
            tempArray[j] = array[j];
        }

        index1 = left;
        index2 = middle + 1;
        i = left;

        while (index1 <= middle && index2 <= right) {
            if (tempArray[index1] <= tempArray[index2]) {
                array[i++] = tempArray[index1++];
            } else {
                array[i++] = tempArray[index2++];
            }
        }

        while (index1 <= middle) {
            array[i++] = tempArray[index1++];
        }

        while (index2 <= right) {
            array[i++] = tempArray[index2++];
        }
    }

}
