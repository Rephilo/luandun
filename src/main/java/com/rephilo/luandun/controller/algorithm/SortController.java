package com.rephilo.luandun.controller.algorithm;

import com.rephilo.luandun.model.param.RandomParam;
import com.rephilo.luandun.service.random.RandomService;
import com.rephilo.luandun.service.sort.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 排序算法接口
 *
 * @author rephilo
 */
@RestController
@RequestMapping("sort")
public class SortController {

    @Autowired
    private SortService sortService;

    @Autowired
    private RandomService randomService;

    /**
     * 插入排序接口
     *
     * @param param
     * @return
     */
    @GetMapping("insertSort")
    public Object insertSort(RandomParam param) {
        return sortService.insertSort(randomService.getRandomNumberInts(param));
    }

    /**
     * 希尔排序接口
     *
     * @param param
     * @return
     */
    @GetMapping("shellSort")
    public Object shellSort(RandomParam param) {
        return sortService.shellSort(randomService.getRandomNumberInts(param));
    }

    /**
     * 选择排序
     *
     * @param param
     * @return
     */
    @GetMapping("selectSort")
    public Object selectSort(RandomParam param) {
        return sortService.selectSort(randomService.getRandomNumberInts(param));
    }

    /**
     * 堆排序
     *
     * @param param
     * @return
     */
    @GetMapping("heapSort")
    public Object heapSort(RandomParam param) {
        return sortService.heapSort(randomService.getRandomNumberInts(param));
    }

    /**
     * 冒泡排序
     *
     * @param param
     * @return
     */
    @GetMapping("bubbleSort")
    public Object bubbleSort(RandomParam param) {
        return sortService.bubbleSort(randomService.getRandomNumberInts(param));
    }

    /**
     * 快速排序
     *
     * @param param
     * @return
     */
    @GetMapping("quickSort")
    public Object quickSort(RandomParam param) {
        return sortService.quickSort(randomService.getRandomNumberInts(param));
    }

    /**
     * 归并排序
     *
     * @param param
     * @return
     */
    @GetMapping("mergeSort")
    public Object mergeSort(RandomParam param) {
        return sortService.mergeSort(randomService.getRandomNumberInts(param));
    }
}