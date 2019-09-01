package com.microClient.microclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ClientService {

	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private RestTemplateBuilder builder;
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
	private ServiceProxy serviceProxy;
	
	
	//@HystrixCommand(fallbackMethod="unknown")
	public ResponseEntity<String> callGatewayService() {
		System.out.println("in callGatewayService");
		/*restTemplate=builder.build();
		InstanceInfo gatewayServiceInfo = eurekaClient.getNextServerFromEureka("gateway-service", false);
		InstanceInfo ServiceInfo = eurekaClient.getNextServerFromEureka("service", false);
		String gatewayServiceUrl = gatewayServiceInfo.getHomePageUrl();
		String url = gatewayServiceInfo.getHomePageUrl() + "gateway-service" + "/properties";
		System.out.println("url :-  " + url);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);*/
		
		//using  feignClient
		ResponseEntity<String> response=	new ResponseEntity<>(serviceProxy.callGatewayService(), HttpStatus.OK);
		return response;

	}
	
	@HystrixCommand(fallbackMethod="unknown")
	public ResponseEntity<String> callDefaultService() {
		//RestTemplate restTemplate = builder.build();
		InstanceInfo gatewayServiceInfo = eurekaClient.getNextServerFromEureka("gateway-service", false);
		InstanceInfo ServiceInfo = eurekaClient.getNextServerFromEureka("service", false);
		String gatewayServiceUrl = gatewayServiceInfo.getHomePageUrl();

		String url = gatewayServiceInfo.getHomePageUrl() + ServiceInfo.getAppName().toLowerCase() + "/";
		// url=gatewayServiceUrl+"service/";
		url=ServiceInfo.getHomePageUrl();
		
		System.out.println("url :-  " + url);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
		return response;

	}
	public ResponseEntity<String> unknown() {
		return new ResponseEntity<String>("unknown",HttpStatus.BAD_REQUEST);
	}

	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
