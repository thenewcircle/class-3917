package com.example.cucumber.selenium;

import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BuyPage {

	public static final Pattern[] VALID_URL_PATTERNS = {
		Pattern.compile("https://([^/]+)/products/([^?/])+"),
	};
	
	public static void assertValidURL(WebDriver wd) {
		MyPages.assertValidURL(wd, VALID_URL_PATTERNS);
	}

	private final WebDriver wd; 
	
	public BuyPage(WebDriver wd) {
		this.wd = wd;
		assertValidURL(wd);
	}

	public CartPage clickAddToCart() {
        wd.findElement(By.id("add-to-cart-button")).click();
        return new CartPage(wd);
	}

	public ShopPage clickFeaturedLink() {
        wd.findElement(By.linkText("Featured")).click();
        return new ShopPage(wd);
	}

}
