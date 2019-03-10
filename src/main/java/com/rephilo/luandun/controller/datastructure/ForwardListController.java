package com.rephilo.luandun.controller.datastructure;

import com.rephilo.luandun.service.datastructure.ForwardListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 极简数据结构 第4章 链表
 *
 * @author rephilo
 */
@RequestMapping("list")
@RestController
public class ForwardListController {

    @Autowired
    private ForwardListService forwardListService;

    @RequestMapping("forwardList")
    public Object getForwardList(@RequestParam(required = false) int[] data) {
        return forwardListService.getForwardList(data);
    }

    @RequestMapping("reverse")
    public Object reverseList(@RequestParam(required = false) int[] data) {
        return forwardListService.reverseList(forwardListService.getForwardList(data));
    }
}
