package com.example.banking;

public class ConfigurationService {

	private static AccountDAO accountDAO;
	private static BankingService bankingService;
	
	static {
		reset();
	}

	public static synchronized void reset() {
		accountDAO = new InMemoryAccountDAO();
		bankingService = new SimpleBankingService(accountDAO);
	}

	public static AccountDAO getAccountDAO() {
		return accountDAO;
	}

	public static BankingService getBankingService() {
		return bankingService;
	}

}
