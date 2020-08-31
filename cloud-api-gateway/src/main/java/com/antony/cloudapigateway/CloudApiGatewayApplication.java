package com.antony.cloudapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * 
 * @author Antony John
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class CloudApiGatewayApplication extends ServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(CloudApiGatewayApplication.class, args);
	}
	
	/**
	 * All requests that pass through that shared WebClient instance require load balancing. 
	 * Just define a provider method for the WebClient.Builder and annotate it with @LoadBalanced.
	 * @return
	 */
	@Bean
    @LoadBalanced
    WebClient.Builder builder() {
        return WebClient.builder();
    }
    
    @Bean
    WebClient webClient(WebClient.Builder builder) {
        return builder.build();
    }

}
