package com.example.banking;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(PowerMockRunner.class)
public class BankingTestWithMocks {

	private static final double ERROR_TOL = 0.00_001;

//	@Before
//	public void resetConfiguration() {
//		ConfigurationService.reset();
//	}
	
	@PrepareForTest(ConfigurationService.class)
	@Test
	public void testTransfer() throws Exception {
		//1. Create test data / test fixture
		long fromAccountId = 1;
		long toAccountId = 2;
		Account from = new Account(fromAccountId, "Val 401k", 1_000.00);
		Account to = new Account(toAccountId, "Doug 401k", 5.00);
		double amount = 1_000.00;
		
		//2. Setup (Assemble)
		AccountDAO dao = Mockito.mock(AccountDAO.class);
		BankingService teller = new SimpleBankingService(dao);
		when(dao.find(fromAccountId)).thenReturn(from);
		when(dao.find(toAccountId)).thenReturn(to);
		PowerMockito.mockStatic(ConfigurationService.class);
		Mockito.when(ConfigurationService.getAccountDAO()).thenReturn(dao);
		Mockito.when(ConfigurationService.getBankingService()).thenReturn(teller);
		
		//3. Act (do the business logic)
		teller.transfer(fromAccountId, toAccountId, amount);
		
		//4. Verify the results
		Account finalFrom = dao.find(fromAccountId);
		Account finalTo = dao.find(toAccountId);
		assertEquals(1_000.00 - 1_000.00, finalFrom.getBalance(), ERROR_TOL);
		assertEquals(1_000.00 + 5.00, finalTo.getBalance(), ERROR_TOL);
		verify(dao).update(from);
		verify(dao).update(to);
		
		//5. Cleanup
	}
	
	@Test
	public void testTransferInsuffientBalance() throws AccountNotFoundException {
		//1. Setup (Assemble)
		AccountDAO dao = new InMemoryAccountDAO();
		BankingService teller = new SimpleBankingService(dao);
		
		//2. Create test data / test fixture
		Account from = dao.create("Val 401k", 1_000_000_000.00);
		Account to = dao.create("Doug 401k", 5.00);
		Long fromAccountId = from.getId();
		Long toAccountId = to.getId();
		double amount = 6_000_000_000.00;
		
		//3. Act (do the business logic)
		try {
			teller.transfer(fromAccountId, toAccountId, amount);
			Assert.fail("Should throw InsufficientBalanceException");
		} catch (InsufficientBalanceException e) {
			Assert.assertEquals(fromAccountId, e.getAccountId());
			Assert.assertEquals(1_000_000_000.00, e.getAccountBalance(), ERROR_TOL);
			Assert.assertEquals(6_000_000_000.00, e.getWithdrawAmount(), ERROR_TOL);
			Assert.assertEquals("Unable to withdraw $6000000000.00 from Account[id=1, owner=\"Val 401k\", balance=$1000000000.00]", e.getMessage());
		}
			
		//4. Verify the results
		Account finalFrom = dao.find(fromAccountId);
		Account finalTo = dao.find(toAccountId);
		Assert.assertEquals(1_000_000_000.00, finalFrom.getBalance(), ERROR_TOL);
		Assert.assertEquals(5.00, finalTo.getBalance(), ERROR_TOL);
		
		//5. Cleanup
	}
	
	@Test
	public void testTransferNegativeBalance() throws Exception {
		//1. Setup (Assemble)
		AccountDAO dao = new InMemoryAccountDAO();
		BankingService teller = new SimpleBankingService(dao);
		
		//2. Create test data / test fixture
		Account from = dao.create("Val 401k", 1_000_000_000.00);
		Account to = dao.create("Doug 401k", 5.00);
		Long fromAccountId = from.getId();
		Long toAccountId = to.getId();
		double amount = -100.00;
		
		//3. Act (do the business logic)
		try {
			teller.transfer(fromAccountId, toAccountId, amount);
			Assert.fail("Should throw InsufficientBalanceException");
		} catch (IllegalArgumentException e) {
			//Pass
		}
			
		//4. Verify the results
		Account finalFrom = dao.find(fromAccountId);
		Account finalTo = dao.find(toAccountId);
		Assert.assertEquals(1_000_000_000.00, finalFrom.getBalance(), ERROR_TOL);
		Assert.assertEquals(5.00, finalTo.getBalance(), ERROR_TOL);
		
		//5. Cleanup
	}
	
	@Test
	public void testAccountToString() {
		Account a = new Account(1L, "Val 401k", 1_000_000_000.00);
		String expected = "Account[id=1, owner=\"Val 401k\", balance=$1000000000.00]";
		String actual = a.toString();
		Assert.assertEquals(expected, actual);
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
			@SuppressWarnings("unused")
			Account account = dao.find(1L);
			Assert.fail("Expected exception");
		} catch (AccountNotFoundException ex) {
			Assert.assertEquals(Long.valueOf(1), ex.getAccountId());
			Assert.assertEquals("Account #1 was not found", ex.getMessage());
		}

		try {
			AccountDAO dao = new InMemoryAccountDAO();
			@SuppressWarnings("unused")
			Account account = dao.find(2L);
			Assert.fail("Expected exception");
		} catch (AccountNotFoundException ex) {
			Assert.assertEquals(Long.valueOf(2), ex.getAccountId());
			Assert.assertEquals("Account #2 was not found", ex.getMessage());
		}
	}
	
}


