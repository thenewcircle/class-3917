package com.example.pacman.fancy;

import javax.sql.DataSource;

public class ConfigurationServiceTestStub extends ConfigurationService {

	private CustomerService customerService;
	private NetworkAddrService networkAddrService;
	private SecurityService securityService;
	private RequestMessageLogService requestMessageLogService;
	private DistributionEngine distributionEngine;
	private MyValidator myValidator;
	private MyStatelessWorkerBean worker;
	private DataSource regionalDataSource;
	private DataSource globalDataSource;

	public ConfigurationServiceTestStub() {
	}

	public ConfigurationServiceTestStub(ConfigurationService clone) {
		this.customerService = clone.getCustomerService();
		this.networkAddrService = clone.getNetworkAddrService();
		this.securityService = clone.getSecurityService();
		this.requestMessageLogService = clone.getRequestMessageLogService();
		this.distributionEngine = clone.getDistributionEngine();
		this.myValidator = clone.getMyValidator();
		this.worker = clone.getWorker();
		this.regionalDataSource = clone.getRegionalDataSource();
		this.globalDataSource = clone.getGlobalDataSource();
	}


	public CustomerService getCustomerService() {
		return customerService;
	}

	/**
	 * Never call this. Only call this in test cases when injecting a mock. That
	 * test should then call reset() afterwards to clean up this state.
	 */
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public NetworkAddrService getNetworkAddrService() {
		return networkAddrService;
	}

	/**
	 * Never call this. Only call this in test cases when injecting a mock. That
	 * test should then call reset() afterwards to clean up this state.
	 */
	public void setNetworkAddrService(NetworkAddrService networkAddrService) {
		this.networkAddrService = networkAddrService;
	}

	public SecurityService getSecurityService() {
		return securityService;
	}

	/**
	 * Never call this. Only call this in test cases when injecting a mock. That
	 * test should then call reset() afterwards to clean up this state.
	 */
	public void setSecurityService(SecurityService securityService) {
		this.securityService = securityService;
	}

	public DistributionEngine getDistributionEngine() {
		return distributionEngine;
	}

	/**
	 * Never call this. Only call this in test cases when injecting a mock. That
	 * test should then call reset() afterwards to clean up this state.
	 */
	public void setDistributionEngine(DistributionEngine distributionEngine) {
		this.distributionEngine = distributionEngine;
	}

	public MyValidator getMyValidator() {
		return myValidator;
	}

	/**
	 * Never call this. Only call this in test cases when injecting a mock. That
	 * test should then call reset() afterwards to clean up this state.
	 */
	public void setMyValidator(MyValidator myValidator) {
		this.myValidator = myValidator;
	}

	public MyStatelessWorkerBean getWorker() {
		return worker;
	}

	/**
	 * Never call this. Only call this in test cases when injecting a mock. That
	 * test should then call reset() afterwards to clean up this state.
	 */
	public void setWorker(MyStatelessWorkerBean worker) {
		this.worker = worker;
	}

	public DataSource getRegionalDataSource() {
		return regionalDataSource;
	}

	/**
	 * Never call this. Only call this in test cases when injecting a mock. That
	 * test should then call reset() afterwards to clean up this state.
	 */
	public void setRegionalDataSource(DataSource regionalDataSource) {
		this.regionalDataSource = regionalDataSource;
	}

	public DataSource getGlobalDataSource() {
		return globalDataSource;
	}

	/**
	 * Never call this. Only call this in test cases when injecting a mock. That
	 * test should then call reset() afterwards to clean up this state.
	 */
	public void setGlobalDataSource(DataSource globalDataSource) {
		this.globalDataSource = globalDataSource;
	}

	public RequestMessageLogService getRequestMessageLogService() {
		return requestMessageLogService;
	}

	/**
	 * Never call this. Only call this in test cases when injecting a mock. That
	 * test should then call reset() afterwards to clean up this state.
	 */
	public void setRequestMessageLogService(
			RequestMessageLogService requestMessageLogService) {
		this.requestMessageLogService = requestMessageLogService;
	}

}
