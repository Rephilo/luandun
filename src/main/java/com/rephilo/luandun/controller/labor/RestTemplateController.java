package com.rephilo.luandun.controller.labor;

import com.google.common.collect.Lists;
import com.rephilo.luandun.model.labor.excel.ExcelConstant;
import com.rephilo.luandun.model.labor.excel.ExcelData;
import com.rephilo.luandun.model.labor.excel.ExcelUtils;
import com.sun.jdi.IntegerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

@RestController
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/diff")
    public Object diff() throws Exception {


        BufferedReader br = null;
        br = new BufferedReader(new FileReader("dpId.csv"));

//        ExcelData data = new ExcelData();
//        List<String> title = Lists.newArrayList();

//        title.add("realNum");
//        title.add("prodNum");
//        title.add("diff");

//        data.setTitles(title);

//        List<List<Object>> rows = Lists.newArrayList();
        String line;
        List<Integer> dpIdList = Lists.newArrayList();
        while ((line = br.readLine()) != null) {
            String[] ss = line.split("\\t");

            int dpId = Integer.parseInt(ss[0]);

            dpIdList.add(dpId);
        }

//        dpIdList.parallelStream().forEach(this::refresh);
//        data.setRows(rows);
//        ExcelUtils.generateExcel(data, ExcelConstant.FILE_PATH + System.currentTimeMillis() + ExcelConstant.FILE_NAME);
        System.out.println("finish");
        return "ok";
    }
}
