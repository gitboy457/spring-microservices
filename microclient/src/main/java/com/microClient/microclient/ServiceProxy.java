package com.microClient.microclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="${gateway.id}",fallback=ServiceFallback.class)
public interface ServiceProxy {
	@GetMapping("/service-request/properties")
	public String callGatewayService();
	
	//http://localhost:8080/service-properties
//http://localhost:8777/service-request/properties
	
//	http://localhost:8081/properties
}
