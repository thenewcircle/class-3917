package com.example.pacman.fancy;

public class DistributionEngine {

	private NetworkAddrService networkAddrService;
	private CustomerService customerService;
	
	public void distribute(Object msg) {
		
	}

	public void setNetworkAddrService(NetworkAddrService networkAddrService) {
		this.networkAddrService = networkAddrService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
}
