package com.rephilo.luandun.service.random;

import com.google.common.collect.Lists;
import com.rephilo.luandun.model.param.RandomParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 生成随机数Service
 *
 * @author rephilo
 */
@Service
public class RandomService {

    /**
     * 生成随机数集合
     *
     * @param param 生成随机数的参数
     * @return 随机数集合
     */
    public List<Integer> getRandomNumberList(RandomParam param) {
        return new Random()
                .ints(param.getSize(),
                        param.getFrom(),
                        param.getTo())
                .parallel()
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * 生成随机数集合
     *
     * @param param
     * @return 随机数数组
     */
    public int[] getRandomNumberInts(RandomParam param) {
        return getRandomNumberList(param)
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
