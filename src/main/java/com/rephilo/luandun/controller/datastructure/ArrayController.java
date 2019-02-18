package com.rephilo.luandun.controller.datastructure;

import com.rephilo.luandun.service.datastructure.ArrayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 极简数据结构 第1章 数组
 */
@RestController
@RequestMapping("array")
public class ArrayController {

    @Autowired
    private ArrayService arrayService;

    /**
     *
     * @param n
     * @param x
     * @param y
     * @return
     */
    @GetMapping("diagonal")
    public Object diagonal(Integer n, Integer x, Integer y) {
        return arrayService.diagonal();
    }
}
