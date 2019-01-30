package com.rephilo.luandun.controller.fixData;

import com.google.common.collect.Maps;
import com.rephilo.luandun.executor.ForkJoinPoolUtils;
import com.rephilo.luandun.executor.task.RemovieTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class FixController {

    public static volatile Integer SLEEP_TIME = 1;

    private Logger logger = LoggerFactory.getLogger(FixController.class);

    @Autowired
    private RestTemplate restTemplate;
}
