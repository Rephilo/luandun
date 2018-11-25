package com.rephilo.luandun.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 数据库配置
 *
 * @author rephilo
 */
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = "com.rephilo.luandun.dao.db")
public class DataBaseConfig {
//    @Primary
//    @Bean
//    public DataSource dataSource(){
//        return DruidDataSourceBuilder.create().build();
//    }
}
