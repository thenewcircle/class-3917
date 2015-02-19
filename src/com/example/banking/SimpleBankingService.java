package com.example.banking;

public class SimpleBankingService implements BankingService {

	private AccountDAO dao;

	public SimpleBankingService(AccountDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public void transfer(long fromAccountId, long toAccountId, double amount) {
		//AccountDAO dao = ConfigurationService.getAccountDAO();
		Account from = dao.find(fromAccountId);
		Account to = dao.find(toAccountId);
		
		double fromBal = from.getBalance();
		fromBal -= amount;
		from.setBalance(fromBal);
		
		double toBal = to.getBalance();
		toBal += amount;
		to.setBalance(toBal);
		
		dao.update(from);
		dao.update(to);
	}

}
