package com.musalasoft.gateways;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication(scanBasePackages={
//"com.musalasoft.gateways.api", "com.musalasoft.gateways.dao", 
//"com.musalasoft.gateways.model", "com.musalasoft.gateways.service"})
public class GatewaysApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewaysApplication.class, args);
	}

}
