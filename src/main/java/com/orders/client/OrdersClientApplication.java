package com.orders.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class OrdersClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersClientApplication.class, args);
	}

}
