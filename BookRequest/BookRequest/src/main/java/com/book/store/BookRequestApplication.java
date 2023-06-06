package com.book.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {
		"com.book.store.controller",
		"com.book.store.configs",
		"com.book.store.daos",
		"com.book.store.dao",
		"com.book.store.dtos",
		"com.book.store.exception",
		"com.book.store.model",
		"com.book.store.models",
		
		"com.book.store.service",
		"com.book.store.util"		
})
public class BookRequestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookRequestApplication.class, args);
		System.out.println("BookRequest service is running....");
	}
	
	@Bean
	//@LoadBalanced
	public RestTemplate restTemplateBean() {
	        return new RestTemplate();
	}

}
