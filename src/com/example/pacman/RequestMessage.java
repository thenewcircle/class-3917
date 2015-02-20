package com.example.pacman;

import java.util.List;

public class RequestMessage {

	private String[] customerNames;
	private List<ValidationError> errors;

	public RequestMessage(String... customerNames) {
		this.customerNames = customerNames;
	}

	public String[] getCustomerNames() {
		return customerNames;
	}

	public void setCustomerNames(String... customerName) {
		this.customerNames = customerName;
	}

	public static RequestMessage parse(String json) {
		String[] names = json.split(" *, *");
		return new RequestMessage(names);
	}

	public void setErrors(List<ValidationError> errors) {
		this.errors = errors;
	}

	public List<ValidationError> getErrors() {
		return errors;
	}

}
