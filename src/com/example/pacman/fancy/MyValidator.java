package com.example.pacman.fancy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyValidator {

	private CustomerService customerService;
	private RequestMessageLogService messageLogService;
	
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
			messageLogService.logValidationErrors(errors);
		}
		return errors;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setRequestMessageLogService(
			RequestMessageLogService messageLogService) {
		this.messageLogService = messageLogService;
	}
	
	
	
}
