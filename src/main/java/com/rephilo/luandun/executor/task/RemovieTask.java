package com.rephilo.luandun.executor.task;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.concurrent.RecursiveTask;

public class RemovieTask extends RecursiveTask<Integer> {

    private Logger logger = LoggerFactory.getLogger(RemovieTask.class);

    private List<String> lines;

    private RestTemplate restTemplate;

    public RemovieTask(List<String> lines, RestTemplate restTemplate) {
        this.lines = lines;
        this.restTemplate = restTemplate;
    }

    @Override
    protected Integer compute() {
        if (this.lines.size() > 100) {
            List<List<String>> partitionList = Lists.partition(this.lines, 100);
            List<RemovieTask> taskList = Lists.newArrayList();
            partitionList.stream().forEach(s -> {
                taskList.add(new RemovieTask(s, this.restTemplate));
            });

            invokeAll(taskList);

        } else {
            for (String line : this.lines) {
                removieRecommend(line);
            }
        }
        return null;
    }

    private void removieRecommend(String line) {
        String[] ss = line.split("\\t");
        long mtUserId = Long.parseLong(ss[0]);
        int mtMovieId = Integer.parseInt(ss[1]);

        String reviewTestUrl = "http://maoyanapi.vip.sankuai.com/review/tmp/testApi?className={className}&methodName={methodName}&types={types}&params={params}";

        Map<String, String> dpUserIdParam = Maps.newHashMap();
        dpUserIdParam.put("className", "com.meituan.service.movie.review.adapter.MappingService");
        dpUserIdParam.put("methodName", "getDpUserId");
        dpUserIdParam.put("types", "long");
        dpUserIdParam.put("params", String.valueOf(mtUserId));

        String dpUserId = this.restTemplate.getForEntity(reviewTestUrl, String.class, dpUserIdParam).getBody();

        Map<String, String> dpMovieIdParam = Maps.newHashMap();
        dpMovieIdParam.put("className", "com.meituan.service.movie.review.adapter.MappingService");
        dpMovieIdParam.put("methodName", "getDpMovieId");
        dpMovieIdParam.put("types", "int");
        dpMovieIdParam.put("params", String.valueOf(mtMovieId));

        String dpMovieId = this.restTemplate.getForEntity(reviewTestUrl, String.class, dpMovieIdParam).getBody();

        Map<String, String> removeRecommendParam = Maps.newHashMap();
        removeRecommendParam.put("className", "com.dianping.ugc.dprecommend.remote.RecommendAdminService");
        removeRecommendParam.put("methodName", "removeRecommendByBusiness");
        removeRecommendParam.put("types", "long,int,java.util.List(java.lang.String)");
        removeRecommendParam.put("params", dpUserId + ",," + "17" + ",," + "[" + dpMovieId + "]");

        this.restTemplate.getForEntity(reviewTestUrl, String.class, removeRecommendParam).getBody();

        logger.info("dpUserId: {}, dpMovieId: {}, mtUserId: {}, mtMovieId: {}", dpUserId, dpMovieId, mtUserId, mtMovieId);
    }
}
