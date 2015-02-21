package com.example.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(threadPoolSize=3)
public class AdderTest {

	@Test(enabled=false)
	public static void takeAWhile() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	@DataProvider(name="addData", parallel=true)
	public Object[][] testDataProvider() {
		return new Object[][] {
				{1L,1L,10L},
				{1L,3L,4L},
				{2L,3L,5L},
		};
	}
	
	@Test(dataProvider="addData")
	public void testAdd(long a, long b, long expectedResult) {
		Assert.assertEquals(Adder.add(a, b), expectedResult);
	}
	
	@Test
	public void addOnePlusOne() {
		takeAWhile();
		Assert.assertEquals(Adder.add(1, 1), 2);
	}
	
	@Test(groups={"slow", "math"})
	public void addOnePlusTwo() {
		takeAWhile();
		Assert.assertEquals(Adder.add(1, 2), 3);
	}
	
	@Test(dependsOnMethods="addOnePlusOne", groups="fast")
	public void addTwoPlusFive() {
		takeAWhile();
		Assert.assertEquals(Adder.add(3, 2), 5);
	}
	
}
