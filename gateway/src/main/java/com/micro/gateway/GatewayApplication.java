package com.micro.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	//http://localhost:8777/service/
	//http://localhost:8777/service/properties
	//address-of-gateway/service-id/endpoint
	
	//gateway-service is mapped to http://localhost:8777/service
	//http://localhost:8777/gateway-service/

}
