package com.example.banking;

import org.junit.Test;

public class BankingTest {

	/**
	 * This won't yet compile.  Not all code is written.
	 * 
	 * Notice this code is a much better design....
	 * + The user must do 1 function call to transfer money.
	 * + Could be optimized to have only 1 database call
	 * + Any transaction logic is hidden behind the scenes
	 * + There no a security issue with "setBalance".
	 */
	@Test
	public void testTransfer() {
		BankingService teller = new SimpleBankingService();
		long fromAccountId = 1;
		long toAccountId = 2;
		double amount = 1_000_000_000.00;
		teller.transfer(fromAccountId, toAccountId, amount);
	}
	
}
