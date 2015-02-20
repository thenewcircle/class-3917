package com.example.pacman;

public class DistributionEngine {

	CustomerService customerService;
	NetworkAddrService networkAddrService;
	SecurityService securityService;
	JmsService jmsService;

	public void buildMessages(RequestMessage request) {
		jmsService.sendMessage("verizon", "request1");
		jmsService.sendMessage("bell-atlantic", "request2");
		jmsService.sendMessage("tmobile", "request3");
		jmsService.sendMessage("sieraTelephone", "request4");
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setNetworkAddrService(NetworkAddrService networkAddrService) {
		this.networkAddrService = networkAddrService;
	}

	public void setSecurityService(SecurityService securityService) {
		this.securityService = securityService;
	}

	public void setJmsService(JmsService jmsService) {
		this.jmsService = jmsService;
	}

	
}
