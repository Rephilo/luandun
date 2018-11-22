package com.rephilo.luandun.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;

/**
 * ES配置类
 *
 * @author rephilo
 */
@Configuration
@EnableElasticsearchRepositories("com.rephilo.luandun.dao.es")
public class ElasticSearchConfig {

    @Bean
    public TransportClient transportClient() throws Exception {
        //初始化配置
        Settings settings = Settings.builder()
                .put("cluster.name", "docker-cluster")
                .build();

        //返回客户端
        return new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));

    }

    /**
     * 返回es操作类
     *
     * @return
     * @throws Exception
     */
    @Bean
    public ElasticsearchTemplate elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(transportClient());
    }
}
