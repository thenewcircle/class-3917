package com.example.pacman;

import java.util.ArrayList;
import java.util.List;

public class MyValidator {

	private CustomerService customerService;
	private NetworkAddrService networkAddrService;
	private RequestMessageLogService requestMessageLogService;

	public List<ValidationError> validate(RequestMessage request) {
		Object customer = customerService.findCustomer();
		Object network = networkAddrService.getNetworkAddr();
		List<ValidationError> errors = new ArrayList<>();
		for (String name : request.getCustomerNames()) {
			ValidationError e = new ValidationError(name, 7032);
			errors.add(e);
		}
		if (!errors.isEmpty()) {
			for (ValidationError e : errors) {
				requestMessageLogService.log(e);
			}
		}
		return errors;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setNetworkAddrService(NetworkAddrService networkAddrService) {
		this.networkAddrService = networkAddrService;
	}

	public void setRequestMessageLogService(
			RequestMessageLogService requestMessageLogService) {
		this.requestMessageLogService = requestMessageLogService;
	}

}
