package com.example.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BeforeAfterTest {

	@BeforeClass
	public static void runsBeforeFirstTestInClass() {
		System.out.println("BeforeAfterTest.runsBeforeFirstTestInClass()");
	}

	@AfterClass
	public static void runsAfterLastTestInClass() {
		System.out.println("BeforeAfterTest.runsAfterLasttTestInClass()");
	}

	@Before
	public void runsBeforeEachTest() {
		System.out.println("BeforeAfterTest.runsBeforeEachTest()");
	}

	@After
	public void runsAfterEachTest() {
		System.out.println("BeforeAfterTest.runsAfterEachTest()");
	}

	@Test
	public void testA() {
		System.out.println("BeforeAfterTest.testA()");
	}

	@Test
	public void testB() {
		System.out.println("BeforeAfterTest.testB()");
	}

	@Test
	public void testC() {
		System.out.println("BeforeAfterTest.testC()");
	}

}
