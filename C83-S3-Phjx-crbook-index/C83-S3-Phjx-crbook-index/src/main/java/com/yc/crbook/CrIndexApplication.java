package com.yc.crbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;


//服务降级注解
@EnableCircuitBreaker
@SpringBootApplication
@EnableFeignClients
public class CrIndexApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrIndexApplication.class, args);
	}

}
