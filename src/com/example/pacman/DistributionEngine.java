package com.example.pacman;

public class DistributionEngine {

	public void buildMessages(RequestMessage request) {
		CustomerService customerService = new CustomerService();
		NetworkAddrService networkAddrService = new NetworkAddrService();
		SecurityService securityService = new SecurityService();
		JmsService jmsService = new JmsService();
		jmsService.sendMessage("verizon", "request1");
		jmsService.sendMessage("bell-atlantic", "request2");
		jmsService.sendMessage("tmobile", "request3");
		jmsService.sendMessage("sieraTelephone", "request4");
	}

}
