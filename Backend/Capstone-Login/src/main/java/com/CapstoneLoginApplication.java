package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication(scanBasePackages = "com")
@EntityScan(basePackages = "com.bean")	
@EnableJpaRepositories(basePackages = "com.repository")
@EnableDiscoveryClient

public class CapstoneLoginApplication {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
		
	}
	public static void main(String[] args) {
		SpringApplication.run(CapstoneLoginApplication.class, args);
		System.out.println("Login Microservice up on port 8181");
	}
	
}
