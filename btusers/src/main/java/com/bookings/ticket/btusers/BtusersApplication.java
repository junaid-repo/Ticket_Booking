package com.bookings.ticket.btusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BtusersApplication {

	public static void main(String[] args) {
		SpringApplication.run(BtusersApplication.class, args);
	}

}
