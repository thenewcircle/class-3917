package com.example.cucumber.selenium;

import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private static final String HOME_URL = "https://awesome-boutique-9152.spree.mx/";

	private static final Pattern[] VALID_URL_PATTERNS = {
		Pattern.compile("^https://([^/]+)/$"),
	};

	public static void assertValidURL(WebDriver wd) {
		MyPages.assertValidURL(wd, VALID_URL_PATTERNS);
	}

	public static HomePage goTo(WebDriver wd) {
		wd.get(HOME_URL);
		return new HomePage(wd);
	}
	
	private final WebDriver wd;

	public HomePage(WebDriver wd) {
		this.wd = wd;
		String currentPage = wd.getCurrentUrl();
		if (currentPage.equals(HOME_URL))
			return;
		throw new IllegalStateException("Browser is on the wrong page.");
	}
	
	public ShopPage clickShopPage() {
        wd.findElement(By.cssSelector("div.container > nav.columns.seven > #main-nav-bar > #shop-link > a[href='/products']")).click();
        return new ShopPage(wd);
	}

}
