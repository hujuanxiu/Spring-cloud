package com.yc.crbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yc.crbook.web.LoginInterceptor;


//服务降级注解
@EnableCircuitBreaker
@SpringBootApplication
@EnableFeignClients
public class CrIndexApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(CrIndexApplication.class, args);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns(
				"/cart.html",
				"/tocart",
				"/user_home.html",
				"/user_profile.html",
				"/user_edit.html",
				"/user_order.html");
	}
	
	

}
