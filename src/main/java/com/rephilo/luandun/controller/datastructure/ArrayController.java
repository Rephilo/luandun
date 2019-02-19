package com.rephilo.luandun.controller.datastructure;

import com.rephilo.luandun.service.datastructure.ArrayService;
import com.rephilo.luandun.utils.LuandunUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 极简数据结构 第1章 数组
 *
 * @author rephilo
 */
@RestController
@RequestMapping("array")
public class ArrayController {

    @Autowired
    private ArrayService arrayService;

    /**
     * 对角线问题
     *
     * @param n
     * @param x
     * @param y
     * @return
     */
    @GetMapping("diagonal")
    public Object diagonal(@RequestParam(required = false, defaultValue = "16") Integer n,
                           @RequestParam(required = false, defaultValue = "1") Integer x,
                           @RequestParam(required = false, defaultValue = "0") Integer y) {
        return LuandunUtils.layoutArray(arrayService.diagonal(n, x, y));
    }

    /**
     * 二分查找
     *
     * @return
     */
    @GetMapping("binarySearch")
    public Object binarySearchArray(@RequestParam(required = false, defaultValue = "0") Integer key,
                                    @RequestParam(required = false) int[] data) {
        return arrayService.binarySearchArray(key, data);
    }
}
