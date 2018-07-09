package com.rephilo.luandun.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(value = "com.rephilo.luandun.db.dao")
public class JpaConfigration {
}
