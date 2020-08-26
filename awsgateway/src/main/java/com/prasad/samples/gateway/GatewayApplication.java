package com.prasad.samples.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.security.oauth2.gateway.TokenRelayGatewayFilterFactory;

@EnableEurekaClient
@SpringBootApplication
public class GatewayApplication {

	@Autowired
	private TokenRelayGatewayFilterFactory filterFactory;
	
	/*
	 * @Bean public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
	 * return builder.routes() .route("doctor", r -> r.path("/doctorservice/**")
	 * .filters(f -> f.filters(filterFactory.apply()).removeRequestHeader("Cookie"))
	 * .uri("http://localhost:9091/")) .build(); }
	 */
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	
}
