package com.example.RoomBookingService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.RoomBookingService.config.RsaKeyProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)

public class RoomBookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomBookingServiceApplication.class, args);
	}
}
