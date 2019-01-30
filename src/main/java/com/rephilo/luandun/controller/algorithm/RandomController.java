package com.rephilo.luandun.controller.algorithm;

import com.google.common.collect.Lists;
import com.rephilo.luandun.model.param.RandomParam;
import com.rephilo.luandun.service.random.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 随机数接口
 *
 * @author rephilo
 */
@RestController
public class RandomController {

    @Autowired
    private RandomService randomService;

    @GetMapping("/randomNumbers")
    public Object getRandomNumberList(RandomParam param) {
        List<Integer> randomNumberList = randomService.getRandomNumberList(param);

        return new HttpEntity<List<Integer>>(randomNumberList);
    }
}
