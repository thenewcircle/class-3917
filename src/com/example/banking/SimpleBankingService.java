package com.example.banking;

public class SimpleBankingService implements BankingService {

	private AccountDAO dao;

	public SimpleBankingService(AccountDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public void transfer(long fromAccountId, long toAccountId, double amount) throws AccountNotFoundException, InsufficientBalanceException {
		if (amount < 0) {
			throw new IllegalArgumentException("Amount must be > 0, currently is " + amount);
		}
		
		AccountDAO dao = ConfigurationService.getAccountDAO();
		Account from = dao.find(fromAccountId);
		Account to = dao.find(toAccountId);
		from.subtractFromBalance(amount);
		to.addToBalance(amount);
		dao.update(from);
		dao.update(to);
	}
	
}
