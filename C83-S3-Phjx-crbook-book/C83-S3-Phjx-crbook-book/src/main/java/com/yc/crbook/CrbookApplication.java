package com.yc.crbook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableEurekaClient
//服务降级注解
@EnableCircuitBreaker
@MapperScan("com.yc.crbook.dao")
@EnableFeignClients
@SpringBootApplication
public class CrbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrbookApplication.class, args);
	}

}
