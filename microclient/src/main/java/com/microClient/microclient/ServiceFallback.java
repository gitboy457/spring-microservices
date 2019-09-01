package com.microClient.microclient;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class ServiceFallback implements ServiceProxy{

	@Override
	public String callGatewayService() {
		// TODO Auto-generated method stub
		return "unknown";
	}

}
