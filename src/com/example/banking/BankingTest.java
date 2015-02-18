package com.example.banking;

import org.junit.Test;

public class BankingTest {

	@Test
	public void testTransfer() {
		//1. Setup (Assemble)
		BankingService teller = new SimpleBankingService();
		
		//2. Create test data / test fixture
		long fromAccountId = 1;
		long toAccountId = 2;
		double amount = 1_000_000_000.00;
		
		//3. Act (do the business logic)
		teller.transfer(fromAccountId, toAccountId, amount);
		
		//4. Verify the results
		
		//5. Cleanup
	}
	
}
