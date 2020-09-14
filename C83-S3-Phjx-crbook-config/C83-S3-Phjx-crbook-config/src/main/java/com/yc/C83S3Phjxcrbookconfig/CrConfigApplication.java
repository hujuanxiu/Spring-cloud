package com.yc.C83S3Phjxcrbookconfig;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

//服务降级注解
@EnableCircuitBreaker
@SpringBootApplication
public class CrConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrConfigApplication.class, args);
	}

}
