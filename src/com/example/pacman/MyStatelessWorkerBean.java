package com.example.pacman;

import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class MyStatelessWorkerBean {

	public void doWork(RequestMessage request) {
		ConfigurationService config = ConfigurationService.getInstance();
		MyValidator validator = config.getMyValidator();
		List<ValidationError> errors = validator.validate(request);
		request.setErrors(errors);
		DistributionEngine de = config.getDistributionEngine();
		de.buildMessages(request);
	}

}
