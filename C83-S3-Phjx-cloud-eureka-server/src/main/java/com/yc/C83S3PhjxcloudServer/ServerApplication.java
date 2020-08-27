package com.yc.C83S3PhjxcloudServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableEurekaServer
@SpringBootApplication
public class ServerApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
	
	
	
	
}
