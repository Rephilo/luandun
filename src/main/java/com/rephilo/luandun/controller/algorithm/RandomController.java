package com.rephilo.luandun.controller.algorithm;

import com.rephilo.luandun.model.param.RandomParam;
import com.rephilo.luandun.service.random.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
