package com.example.pacman;

import java.util.ArrayList;
import java.util.List;

public class MyValidator {

	public List<ValidationError> validate(RequestMessage request) {
		CustomerService customerService = new CustomerService();
		NetworkAddrService networkAddrService = new NetworkAddrService();
		Object customer = customerService.findCustomer();
		Object network = networkAddrService.getNetworkAddr();
		List<ValidationError> errors = new ArrayList<>();
		for (String name : request.getCustomerNames()) {
			ValidationError e = new ValidationError(name, 7032);
			errors.add(e);
		}
		return errors;
	}

}
