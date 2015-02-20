package com.example.pacman.fancy;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;

public class ConfigurationServiceSpringJavaConfig extends ConfigurationService {

	private ApplicationContext spring;

	public ConfigurationServiceSpringJavaConfig() {
		//load spring here...
	}

	public CustomerService getCustomerService() {
		return spring.getBean("customerService", CustomerService.class);
	}

	public NetworkAddrService getNetworkAddrService() {
		//TODO
		return null;
	}

	public SecurityService getSecurityService() {
		//TODO
		return null;
	}

	public DistributionEngine getDistributionEngine() {
		//TODO
		return null;
	}

	public MyValidator getMyValidator() {
		//TODO
		return null;
	}

	public MyStatelessWorkerBean getWorker() {
		//TODO
		return null;
	}

	public DataSource getRegionalDataSource() {
		//TODO
		return null;
	}

	public DataSource getGlobalDataSource() {
		//TODO
		return null;
	}

	public RequestMessageLogService getRequestMessageLogService() {
		//TODO
		return null;
	}
	
}
