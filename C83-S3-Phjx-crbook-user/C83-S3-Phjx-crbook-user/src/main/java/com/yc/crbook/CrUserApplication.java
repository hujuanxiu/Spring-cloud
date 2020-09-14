package com.yc.crbook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//服务降级注解
@EnableCircuitBreaker
@SpringBootApplication
@EnableFeignClients
@MapperScan("com.yc.crbook.dao")
public class CrUserApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(CrUserApplication.class, args);
	}

}
