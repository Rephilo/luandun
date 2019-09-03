package com.rephilo.luandun.controller.datastructure;

import com.rephilo.luandun.service.datastructure.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 图
 *
 * @author rephilo
 */
@RequestMapping("graph")
@RestController
public class GraphController {

    @Autowired
    private GraphService graphService;


}
