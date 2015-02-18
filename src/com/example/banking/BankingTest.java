package com.example.banking;

import org.junit.Test;

public class BankingTest {

	/**
	 * This won't yet compile.  Not all code is written.
	 * 
	 * Notice this code is a bad design....
	 * + The user must do 8 function calls just to transfer money.
	 * + There are 4 database calls
	 * + There is no database transaction.
	 * + There is a security issue with "setBalance" and "saveAccount"
	 */
	@Test
	public void testTransfer() {
		BankingService teller = new SimpleBankingService();
		Account from = teller.find(1L);
		Account to = teller.find(2L);
		from.setBalance(from.getBalance() - 10.00);
		to.setBalance(to.getBalance() + 10.00);
		teller.update(from);
		teller.update(to);
	}
	
}
