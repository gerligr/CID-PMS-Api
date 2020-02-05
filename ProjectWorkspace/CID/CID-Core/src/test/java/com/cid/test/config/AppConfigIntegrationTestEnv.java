package com.cid.test.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@ComponentScan("com.cid.service")
@EnableJpaRepositories(basePackages = "com.cid.dao")
@EntityScan(basePackages = {"com.cid.model"})
@PropertySource("classpath:application.properties")
public class AppConfigIntegrationTestEnv {	
	
}

