package com.example.banking;

public class SimpleBankingService implements BankingService {

	@Override
	public void transfer(AccountDAO dao, long fromAccountId, long toAccountId, double amount) {
//		AccountDAO dao = new InMemoryAccountDAO();
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
