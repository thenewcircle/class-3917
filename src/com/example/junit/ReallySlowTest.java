package com.example.junit;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({SlowTest.class, BankingCategory.class})
public class ReallySlowTest {

	@Test
	public void testSlow() throws Exception {
		Thread.sleep(5000);
	}
	
}
