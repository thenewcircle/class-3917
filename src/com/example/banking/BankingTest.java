package com.example.banking;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BankingTest {

	private static final double ERROR_TOL = 0.00_001;

//	@Before
//	public void resetConfiguration() {
//		ConfigurationService.reset();
//	}
	
	@Test
	public void testTransfer() throws AccountNotFoundException {
		//1. Setup (Assemble)
		AccountDAO dao = new InMemoryAccountDAO();
		BankingService teller = new SimpleBankingService(dao);
		
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
		Assert.assertEquals(1_000_000_000.00 - 1_000_000_000.00, finalFrom.getBalance(), ERROR_TOL);
		Assert.assertEquals(1_000_000_000.00 + 5.00, finalTo.getBalance(), ERROR_TOL);
		
		//5. Cleanup
	}
	
	@Test
	public void testAccountIdIsNullIfNotInDatabase() {
		Account account = new Account();
		Assert.assertNull(account.getId());
	}
	
	@Test
	public void testZFindAccountNotFound() {
		try {
			AccountDAO dao = new InMemoryAccountDAO();
			Account account = dao.find(1L);
			Assert.fail("Expected exception");
		} catch (AccountNotFoundException ex) {
			Assert.assertEquals(Long.valueOf(1), ex.getAccountId());
			Assert.assertEquals("Account #1 was not found", ex.getMessage());
		}

		try {
			AccountDAO dao = new InMemoryAccountDAO();
			Account account = dao.find(2L);
			Assert.fail("Expected exception");
		} catch (AccountNotFoundException ex) {
			Assert.assertEquals(Long.valueOf(2), ex.getAccountId());
			Assert.assertEquals("Account #2 was not found", ex.getMessage());
		}
	}
	
}


