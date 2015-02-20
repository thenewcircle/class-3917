package com.example.pacman.fancy;

public class MyStatelessWorkerBean {
	
	private DistributionEngine engine;
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
	
}
