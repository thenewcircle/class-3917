package com.example.cucumber.selenium;

import org.openqa.selenium.By;

public class MyBy {

	public static By altText(String altText) {
		return By.cssSelector("img[alt='" + altText + "']");
	}

}
