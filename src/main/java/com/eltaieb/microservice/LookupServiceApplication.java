package com.eltaieb.microservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.eltaieb.microservice.lookupservice.config.ServiceConstant;
import com.eltaieb.microservice.lookupservice.dao.JpaProductLocaleDao;
import com.eltaieb.microservice.lookupservice.dao.JpaResourceBundleDao;
import com.eltaieb.microservice.lookupservice.entity.LocationEntity;
import com.eltaieb.microservice.lookupservice.entity.ProductLocaleEntity;
import com.eltaieb.microservice.lookupservice.service.model.LocationModel;

@EnableAsync
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableResourceServer
@PropertySource(value = { "classpath:db.properties", "classpath:redis.properties", "classpath:rabbit-mq.properties" })
public class LookupServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LookupServiceApplication.class, args);
	}

	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private JpaProductLocaleDao productLocaleDao;
	@Autowired
	private JpaResourceBundleDao resourceBundleDao;

	List<ProductLocaleEntity> locales = null;

	@Override
	public void run(String... args) throws Exception {

	}

}
