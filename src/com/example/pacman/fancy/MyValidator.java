package com.example.pacman.fancy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class MyValidator {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private RequestMessageLogService requestMessageLogService;
	
	public List<ValidationError> validate(Object msg) {
		List<ValidationError> errors = new ArrayList<ValidationError>();
		if (msg instanceof String[]) {
			String[] customers = (String[]) msg;
			for (String customer : customers) {
				ValidationError error = new ValidationError(7032, customer);
				errors.add(error);
			}
		}
		errors = Collections.unmodifiableList(errors);
		if (!errors.isEmpty()) {
			requestMessageLogService.logValidationErrors(errors);
		}
		return errors;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}
	
	public void setRequestMessageLogService(RequestMessageLogService requestMessageLogService) {
		this.requestMessageLogService = requestMessageLogService;
	}
	
	public RequestMessageLogService getRequestMessageLogService() {
		return requestMessageLogService;
	}
	
}
