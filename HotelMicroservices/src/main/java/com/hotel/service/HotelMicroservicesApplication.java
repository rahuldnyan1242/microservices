package com.hotel.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HotelMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelMicroservicesApplication.class, args);
	}

}
