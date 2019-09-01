package com.ace.resourceServer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Handler {
	
	@GetMapping(value="/customer/{id}")
	public Customer getcustomer(@PathVariable("id") String id) {
		
		long custId=Long.parseLong(id);
		if(1234==custId) {
		
		Customer c=new Customer();
		c.setCustId(1234);
		c.setCustName("anil");
		c.setMobile("8765767536");
		c.setEmailAdd("anil123@gmail.com");
		
		return c;
		}
		
		return null;
	}

}
