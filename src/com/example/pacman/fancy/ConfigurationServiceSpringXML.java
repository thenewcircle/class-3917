package com.example.pacman.fancy;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigurationServiceSpringXML extends ConfigurationService {

	public static ConfigurationServiceSpringXML install() {
		return install("/com/example/pacman/fancy/spring-config-factory.xml");
	}
	
	public static ConfigurationServiceSpringXML install(String xmlFile) {
		ConfigurationServiceSpringXML config = new ConfigurationServiceSpringXML(xmlFile);
		ConfigurationService.setInstance(config);
		return config;
	}

	private final ApplicationContext spring;
	
	public ConfigurationServiceSpringXML(String xmlFile) {
		spring = new ClassPathXmlApplicationContext(xmlFile); 
	}

	@Override
	public CustomerService getCustomerService() {
		return spring.getBean(CustomerService.class);
	}

	@Override
	public NetworkAddrService getNetworkAddrService() {
		return spring.getBean(NetworkAddrService.class);
	}

	@Override
	public SecurityService getSecurityService() {
		return spring.getBean(SecurityService.class);
	}

	@Override
	public DistributionEngine getDistributionEngine() {
		return spring.getBean(DistributionEngine.class);
	}

	@Override
	public MyValidator getMyValidator() {
		return spring.getBean(MyValidator.class);
	}

	@Override
	public MyStatelessWorkerBean getWorker() {
		return new MyStatelessWorkerBean(this);
	}

	@Override
	public DataSource getRegionalDataSource() {
		return spring.getBean("regionalDataSource", DataSource.class);
	}

	@Override
	public DataSource getGlobalDataSource() {
		return spring.getBean("globalDataSource", DataSource.class);
	}

	@Override
	public RequestMessageLogService getRequestMessageLogService() {
		return spring.getBean(RequestMessageLogService.class);
	}
}
