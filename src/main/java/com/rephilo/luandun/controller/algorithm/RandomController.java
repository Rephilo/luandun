package com.rephilo.luandun.controller.algorithm;

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

    public static void main(String[] args) throws Exception {
        Reader in = new FileReader("C:\\Users\\rephi\\IdeaProjects\\luandun\\src\\main\\resources\\csv\\1588071870854.csv");
        Iterable<CSVRecord> zhongtai = CSVFormat.EXCEL.withHeader().parse(in);

        Reader in2 = new FileReader("C:\\Users\\rephi\\IdeaProjects\\luandun\\src\\main\\resources\\csv\\1588082328509.csv");
        Iterable<CSVRecord> meiti = CSVFormat.EXCEL.withHeader().parse(in2);

        Map<String, String> meitiMap = Maps.newHashMap();
        meiti.forEach(x -> meitiMap.put(x.get("content_id"), x.get("subject_type")));

        List<String> sys = Lists.newArrayList();

        for (CSVRecord record : zhongtai) {
            String id = record.get(0);
            String source = record.get(3);

            String sub = meitiMap.get(id);

            if (sub == null) {
                sys.add(id);
                continue;
            }

            if ("101".equals(sub) && "8".equals(source)) {
                System.out.println(id);
            }

            if ("0".equals(sub) && "9".equals(source)) {
                System.out.println(id);
            }
        }

        if(!CollectionUtils.isEmpty(sys)){
            System.out.println(sys);
        }
    }
}
