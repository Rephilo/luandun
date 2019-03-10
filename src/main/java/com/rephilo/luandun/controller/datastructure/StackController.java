package com.rephilo.luandun.controller.datastructure;

import com.rephilo.luandun.model.datastructure.stack.MazeStatus;
import com.rephilo.luandun.service.datastructure.StackService;
import com.rephilo.luandun.utils.LuandunUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 极简数据结构 第5章 栈
 *
 * @author rephilo
 */
@RequestMapping("stack")
@RestController
public class StackController {

    @Autowired
    private StackService stackService;
}
