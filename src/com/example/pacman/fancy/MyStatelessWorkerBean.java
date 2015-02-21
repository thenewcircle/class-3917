package com.example.pacman.fancy;

import org.springframework.beans.factory.annotation.Autowired;

public class MyStatelessWorkerBean {
	
	@Autowired
	private DistributionEngine engine;
	@Autowired
	private MyValidator myValidator;
	
	public MyStatelessWorkerBean() {
		this(ConfigurationService.getInstance());
	}
	
	public MyStatelessWorkerBean(ConfigurationService config) {
		engine = config.getDistributionEngine();
		myValidator = config.getMyValidator();
	}

	public void doWork(Object msg) {
		myValidator.validate(msg);
		Object newMsg = msg;
		engine.distribute(newMsg);
	}

	public DistributionEngine getEngine() {
		return engine;
	}
	
	public MyValidator getMyValidator() {
		return myValidator;
	}
}
