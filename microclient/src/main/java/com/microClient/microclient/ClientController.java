package com.microClient.microclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
     

	@RequestMapping("/service-properties")
	
	public ResponseEntity<String> callGatewayService() {
	
		ResponseEntity<String> response=	clientService.callGatewayService();
		return response;

	}

	
	@RequestMapping("/defaultService")
	public ResponseEntity<String> defaultService() {
	
		ResponseEntity<String> response=	clientService.callDefaultService();
		return response;

	}

	
}
