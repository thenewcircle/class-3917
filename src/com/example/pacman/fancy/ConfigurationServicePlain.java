package com.example.pacman.fancy;

import javax.sql.DataSource;

public class ConfigurationServicePlain extends ConfigurationService {

	private CustomerService customerService;
	private NetworkAddrService networkAddrService;
	private SecurityService securityService;
	private RequestMessageLogService requestMessageLogService;
	private DistributionEngine distributionEngine;
	private MyValidator myValidator;
	private MyStatelessWorkerBean worker;
	private DataSource regionalDataSource;
	private DataSource globalDataSource;

	public ConfigurationServicePlain() {
		regionalDataSource = jndiLookup("/jdbc/RegionalDS", DataSource.class);
		globalDataSource = jndiLookup("/jdbc/GlobalDS", DataSource.class);
		worker = jndiLookup("myWorker", MyStatelessWorkerBean.class);
		customerService = new CustomerService();
		customerService.setDataSource(regionalDataSource);
		networkAddrService = new NetworkAddrService();
		networkAddrService.setDataSource(regionalDataSource);
		securityService = new SecurityService();
		securityService.setDataSource(globalDataSource);
		requestMessageLogService = new RequestMessageLogService();
		requestMessageLogService.setDataSource(regionalDataSource);
		myValidator = new MyValidator();
		myValidator.setCustomerService(customerService);
		distributionEngine = new DistributionEngine();
		distributionEngine.setCustomerService(customerService);
		distributionEngine.setNetworkAddrService(networkAddrService);
	}

	private <T> T jndiLookup(String string, Class<T> type) {
		Object obj = null; // Do lookup
		T result = type.cast(obj);
		return result;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public NetworkAddrService getNetworkAddrService() {
		return networkAddrService;
	}

	public SecurityService getSecurityService() {
		return securityService;
	}

	public DistributionEngine getDistributionEngine() {
		return distributionEngine;
	}

	public MyValidator getMyValidator() {
		return myValidator;
	}

	public MyStatelessWorkerBean getWorker() {
		return worker;
	}

	public DataSource getRegionalDataSource() {
		return regionalDataSource;
	}

	public DataSource getGlobalDataSource() {
		return globalDataSource;
	}

	public RequestMessageLogService getRequestMessageLogService() {
		return requestMessageLogService;
	}
	
}
