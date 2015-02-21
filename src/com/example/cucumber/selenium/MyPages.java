package com.example.cucumber.selenium;

import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;

public class MyPages {
	
	private static double animationDelay = 0.0;

	public static void assertValidURL(String url, Pattern[] validPatterns) {
		if (!isValidURL(url, validPatterns))
			throw new IllegalStateException("Browser is on the wrong page: " + url);
	}
	
	public static void assertValidURL(WebDriver wd, Pattern[] validPatterns) {
		String url = wd.getCurrentUrl();
		assertValidURL(url, validPatterns);
	}

	public static boolean isValidURL(String url, Pattern[] validPatterns) {
		for (Pattern p : validPatterns) {
			if (p.matcher(url).find())
				return true;
		}
		return false;
	}

	public static void animationPause() {
		double delay = animationDelay;
		MyWaits.sleep(delay);
	}
	
	public static synchronized double getAnimationDelay() {
		return animationDelay;
	}
	
	public static synchronized void setAnitmationDelay(double seconds) {
		animationDelay = seconds;
	}
	
}
