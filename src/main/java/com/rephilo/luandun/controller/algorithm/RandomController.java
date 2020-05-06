package com.rephilo.luandun.controller.algorithm;

import com.alibaba.excel.EasyExcel;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.rephilo.luandun.model.param.RandomParam;
import com.rephilo.luandun.service.random.RandomService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public static void main(String[] args) throws Exception {
        Reader in = new FileReader("/Users/wangxiao15/Desktop/movie_sns_sns_news.csv");
        Iterable<CSVRecord> meiti = CSVFormat.EXCEL.withHeader().parse(in);

        Reader in2 = new FileReader("/Users/wangxiao15/Desktop/ID小于30W.csv");
        Iterable<CSVRecord> zhongtai = CSVFormat.EXCEL.withHeader().parse(in2);

        List<String> sys = Lists.newArrayList();

        Set<String> contentIdSet = new HashSet<>();
        for (CSVRecord record : zhongtai) {
            String id = record.get(0);
            String type = record.get(1);
            if ("2".equals(type)) {
                continue;
            }

            contentIdSet.add(id);
        }

        meiti.forEach(r -> {
            String newsId = r.get(0);
            if (!contentIdSet.contains(newsId)) {
                sys.add(newsId);
            }
        });

        System.out.println(sys);
    }
}
