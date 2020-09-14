package com.yc.C83S3Phjxcrbookeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class CrEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrEurekaApplication.class, args);
	}

}
