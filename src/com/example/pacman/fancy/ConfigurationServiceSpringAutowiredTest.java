package com.example.pacman.fancy;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;

public class ConfigurationServiceSpringAutowiredTest {

	@Test
	public void testConfiguration() {
		ConfigurationServiceSpringAutowired.install();
		ConfigurationService config = ConfigurationService.getInstance();
		
		Assert.assertNotNull(config.getCustomerService());
		Assert.assertNotNull(config.getCustomerService().getDataSource());
		
		Assert.assertNotNull(config.getNetworkAddrService());
		Assert.assertNotNull(config.getNetworkAddrService().getDataSource());
		
		Assert.assertNotNull(config.getSecurityService());
		Assert.assertNotNull(config.getSecurityService().getDataSource());
		
		Assert.assertNotNull(config.getDistributionEngine());
		Assert.assertNotNull(config.getDistributionEngine().getCustomerService());
		Assert.assertNotNull(config.getDistributionEngine().getNetworkAddrService());
		
		Assert.assertNotNull(config.getMyValidator());
		Assert.assertNotNull(config.getMyValidator().getCustomerService());
		Assert.assertNotNull(config.getMyValidator().getRequestMessageLogService());
		
		Assert.assertNotNull(config.getWorker());
		Assert.assertNotNull(config.getWorker().getEngine());
		Assert.assertNotNull(config.getWorker().getMyValidator());
		
		Assert.assertNotNull(config.getRequestMessageLogService());
		Assert.assertNotNull(config.getRequestMessageLogService().getDataSource());

		Assert.assertNotNull(config.getRegionalDataSource());
		
		Assert.assertNotNull(config.getGlobalDataSource());
	}

}
