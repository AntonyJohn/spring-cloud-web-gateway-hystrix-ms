package com.antony.angularuiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 
 * @author Antony John
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class AngularUIServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularUIServiceApplication.class, args);
	}

}
