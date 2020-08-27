package com.yc.C83S3Phjxcloudorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@EnableEurekaClient
@SpringBootApplication
public class C83S3PhjxCloudOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(C83S3PhjxCloudOrderApplication.class, args);
	}
	
	/**
	 * 定义RestTemplate Bean
	 */
	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
