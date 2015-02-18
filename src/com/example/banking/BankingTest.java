package com.example.banking;

import org.junit.Assert;
import org.junit.Test;

public class BankingTest {

	private static final double ERROR_TOL = 0.00_001;

	@Test
	public void testTransfer() {
		//1. Setup (Assemble)
		AccountDAO dao = new InMemoryAccountDAO();
		BankingService teller = new SimpleBankingService();
		
		//2. Create test data / test fixture
		Account from = dao.create("Val 401k", 1_000_000_000.00);
		Account to = dao.create("Doug 401k", 5.00);
		long fromAccountId = from.getId();
		long toAccountId = to.getId();
		double amount = 1_000_000_000.00;
		
		//3. Act (do the business logic)
		teller.transfer(fromAccountId, toAccountId, amount);
		
		//4. Verify the results
		Account finalFrom = dao.find(fromAccountId);
		Account finalTo = dao.find(toAccountId);
		Assert.assertEquals(0.00, finalFrom.getBalance(), ERROR_TOL);
		Assert.assertEquals(1_000_000_000.00, finalTo.getBalance(), ERROR_TOL);
		
		//5. Cleanup
	}
	
}
