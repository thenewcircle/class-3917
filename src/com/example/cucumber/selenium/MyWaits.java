package com.example.cucumber.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyWaits {
	
	public static ExpectedCondition<Boolean> expectTitleStartsWithIgnoreCase(final String expectedTitle) {
		ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver browser) {
				return browser.getTitle().toLowerCase()
						.startsWith(expectedTitle);
			}
		};
		return condition;
	}
	
	public static ExpectedCondition<Boolean> expectJQueryDone() {
		ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver browser) {
				if (!(browser instanceof JavascriptExecutor)) {
					//If we can't run JavaScript, then it's done, by definition.
					return Boolean.TRUE;
				}
				JavascriptExecutor scriptEngine = (JavascriptExecutor) browser;
				return (Boolean) scriptEngine.executeScript("return jQuery.active == 0");
			}
		};
		return condition;
	}

	public static void waitForTitleStartsWithIgnoreCase(WebDriver wd, long timeOutInSeconds, final String expectedTitle) {
        WebDriverWait wait = new WebDriverWait(wd, timeOutInSeconds);
		ExpectedCondition<Boolean> condition = expectTitleStartsWithIgnoreCase(expectedTitle);
		wait.until(condition);
	}

	public static void waitForJQueryDone(WebDriver wd, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(wd, timeOutInSeconds);
		ExpectedCondition<Boolean> condition = expectJQueryDone();
		wait.until(condition);
	}

    public static void sleep(double seconds) {
    	long millis = (long) (1000L * seconds);
    	try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}
