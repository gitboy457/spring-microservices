package com.micro.eurekaServerDemo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
@EnableEurekaServer
@SpringBootApplication
@EnableAdminServer
public class EurekaServerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerDemoApplication.class, args);
	}

}
