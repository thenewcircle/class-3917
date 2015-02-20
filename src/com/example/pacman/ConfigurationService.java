package com.example.pacman;

import javax.jms.ConnectionFactory;
import javax.sql.DataSource;

public class ConfigurationService {

	private static final ConfigurationService instance = new ConfigurationService();

	private DataSource regionalDS;
	private DataSource globalDS;
	private ConnectionFactory jmsConnectionFactory;

	private CustomerService customerService;
	private NetworkAddrService networkAddrService;
	private RequestMessageLogService requestMessageLogService;
	private SecurityService securityService;

	private DistributionEngine distributionEngine;
	private MyValidator myValidator;

	private JmsService jmsService;

	public static ConfigurationService getInstance() {
		return instance;
	}

	private ConfigurationService() {
		regionalDS = JndiHelper.jndiLookup("jdbc/RegionalDS", DataSource.class);
		globalDS = JndiHelper.jndiLookup("jdbc/GlobalDS", DataSource.class);
		jmsConnectionFactory = JndiHelper.jndiLookup("jdbc/GlobalDS",
				ConnectionFactory.class);
		customerService = new CustomerService();
		customerService.setDataSource(regionalDS);
		networkAddrService = new NetworkAddrService();
		networkAddrService.setDataSource(regionalDS);
		requestMessageLogService = new RequestMessageLogService();
		requestMessageLogService.setDataSource(regionalDS);
		securityService = new SecurityService();
		securityService.setDataSource(globalDS);
		jmsService = new JmsService();
		jmsService.setJmsConnectionFactory(jmsConnectionFactory);
		distributionEngine = new DistributionEngine();
		distributionEngine.setCustomerService(customerService);
		distributionEngine.setJmsService(jmsService);
		distributionEngine.setNetworkAddrService(networkAddrService);
		distributionEngine.setSecurityService(securityService);
		myValidator = new MyValidator();
		myValidator.setCustomerService(customerService);
		myValidator.setNetworkAddrService(networkAddrService);
		myValidator.setRequestMessageLogService(requestMessageLogService);
	}

	public MyValidator getMyValidator() {
		return myValidator;
	}

	public DistributionEngine getDistributionEngine() {
		return distributionEngine;
	}

}
