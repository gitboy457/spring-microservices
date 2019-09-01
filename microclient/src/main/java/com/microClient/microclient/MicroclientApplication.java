package com.microClient.microclient;

import org.aspectj.apache.bcel.classfile.Unknown;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@EnableDiscoveryClient
@EnableHystrix
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableTurbine
//@EnableAdminServer
@EnableFeignClients
@EnableZuulProxy
@SpringBootApplication
@RestController
public class MicroclientApplication {

	@Autowired
	private EurekaClient eurekaClient;

	/*@Autowired
	private RestTemplateBuilder builder;*/



	public static void main(String[] args) {
		SpringApplication.run(MicroclientApplication.class, args);
	}
	// http://localhost:8080/properties --client
	// http://localhost:8081/properties ---service
	// http://localhost:8777/service/properties --gateway

/*	@RequestMapping("/")
	public String callDefaultService() {
		RestTemplate restTemplate = builder.build();
		InstanceInfo gatewayServiceInfo = eurekaClient.getNextServerFromEureka("gateway-service", false);
		InstanceInfo ServiceInfo = eurekaClient.getNextServerFromEureka("service", false);
		String gatewayServiceUrl = gatewayServiceInfo.getHomePageUrl();

		String url = gatewayServiceInfo.getHomePageUrl() + ServiceInfo.getAppName().toLowerCase() + "/";
		// url=gatewayServiceUrl+"service/";
		System.out.println("url :-  " + url);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
		return response.getBody();

	}

	@RequestMapping("/properties")
	public String callPropertiesService() {
		RestTemplate restTemplate = builder.build();
		InstanceInfo gatewayServiceInfo = eurekaClient.getNextServerFromEureka("gateway-service", false);
		InstanceInfo ServiceInfo = eurekaClient.getNextServerFromEureka("service", false);
		String gatewayServiceUrl = gatewayServiceInfo.getHomePageUrl();
		String url = gatewayServiceInfo.getHomePageUrl() + ServiceInfo.getAppName().toLowerCase() + "/properties";
		System.out.println("url :-  " + url);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
		return response.getBody();

	}*/

	/*@RequestMapping("/service-properties")
	@HystrixCommand(fallbackMethod="unknown")
	public String callGatewayService() {
		RestTemplate restTemplate = builder.build();
		InstanceInfo gatewayServiceInfo = eurekaClient.getNextServerFromEureka("gateway-service", false);
		InstanceInfo ServiceInfo = eurekaClient.getNextServerFromEureka("service", false);
		String gatewayServiceUrl = gatewayServiceInfo.getHomePageUrl();
		String url = gatewayServiceInfo.getHomePageUrl() + "gateway-service" + "/properties";
		System.out.println("url :-  " + url);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
		return response.getBody();

	}
	
	public String unknown() {
		return "unknown";
	}
*/


}
