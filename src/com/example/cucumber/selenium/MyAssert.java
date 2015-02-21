package com.example.cucumber.selenium;

import static org.junit.Assert.*;

public class MyAssert {
    public static void contains(String expectedSubstring, String actualString) {
    	if (actualString == null) {
    		String msg = String.format("expected to contain \"%s\" but got null.", expectedSubstring);
    		fail(msg);
    	}
    	if (expectedSubstring == null) {
    		throw new IllegalArgumentException("expectedString shouldn't be null");
    	}
    	if (!actualString.contains(expectedSubstring))
    	{
    		String msg = String.format("expected to contain \"%s\" but got \"%s\".", expectedSubstring, actualString);
    		fail(msg);
    	}
    }
}
