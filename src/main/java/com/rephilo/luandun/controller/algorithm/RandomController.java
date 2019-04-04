package com.rephilo.luandun.controller.algorithm;

import com.rephilo.luandun.model.param.RandomParam;
import com.rephilo.luandun.service.random.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

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
