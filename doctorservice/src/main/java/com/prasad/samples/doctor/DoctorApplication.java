package com.prasad.samples.doctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class DoctorApplication {

	@Bean
	@LoadBalanced
	public RestTemplate rest() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(DoctorApplication.class, args);
	}

}
