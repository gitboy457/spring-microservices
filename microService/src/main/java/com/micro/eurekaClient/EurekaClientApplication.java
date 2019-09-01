package com.micro.eurekaClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RefreshScope
@RestController
public class EurekaClientApplication {
	@Value("${service.instance.name}")
	private String instance;
	
    @Autowired
	private ServiceConfiguration configuration;
    
    @Value("${application.url}")
    private String properties;
    
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

	@RequestMapping("/")
	public String message() {
		return "hello from " + instance;
	}
	
	@RequestMapping("/properties")
	public String properties() {
		return "hello from " + properties;
	}
	
}
