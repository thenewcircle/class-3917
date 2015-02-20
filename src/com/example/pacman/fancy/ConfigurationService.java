package com.example.pacman.fancy;

import javax.sql.DataSource;

public abstract class ConfigurationService {

	private static ConfigurationService instance;
	
	static {
		reset();
	}

	public static synchronized ConfigurationService getInstance() {
		return instance;
	}

	public static synchronized void setInstance(ConfigurationService service) {
		ConfigurationService.instance = service;
	}
	
	public static void reset() {
		ConfigurationService config = new ConfigurationServicePlain();
		setInstance(config);
	}
	
	/**
	 * This is a fancier version that allows for overriding the config via a
	 * system property. You probably don't need this added complexity, but we
	 * wanted to show it's possible.
	 */
	public static void resetFancy() {
		try {
			ConfigurationService config = createConfig();
			setInstance(config);
		} catch (RuntimeException | Error e) {
			setInstance(null);
			throw e;
		}
	}

	private static ConfigurationService createConfig() {
		String configClassName = System.getProperty("com.example.config.class");
		if (configClassName == null) {
			ConfigurationService config = new ConfigurationServicePlain();
			return config;
		}
		try {
			Class<? extends ConfigurationService> configClass = Class.forName(configClassName).asSubclass(ConfigurationService.class);
			ConfigurationService config = configClass.newInstance();
			return config;
		} catch (Exception e) {
			throw new IllegalStateException("Unable to create config: " + configClassName, e);
		}
	}

	public abstract CustomerService getCustomerService();

	public abstract NetworkAddrService getNetworkAddrService();

	public abstract SecurityService getSecurityService();

	public abstract DistributionEngine getDistributionEngine();

	public abstract MyValidator getMyValidator();

	public abstract MyStatelessWorkerBean getWorker();

	public abstract DataSource getRegionalDataSource();

	public abstract DataSource getGlobalDataSource();

	public abstract RequestMessageLogService getRequestMessageLogService();

}
