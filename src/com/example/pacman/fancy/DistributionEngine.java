package com.example.pacman.fancy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class DistributionEngine {

	@Autowired
	private NetworkAddrService networkAddrService;
	@Autowired
	private CustomerService customerService;
	
	public void distribute(Object msg) {
		
	}

	public void setNetworkAddrService(NetworkAddrService networkAddrService) {
		this.networkAddrService = networkAddrService;
	}

	public NetworkAddrService getNetworkAddrService() {
		return networkAddrService;
	}
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	public CustomerService getCustomerService() {
		return customerService;
	}
}
