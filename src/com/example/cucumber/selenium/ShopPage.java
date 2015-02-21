package com.example.cucumber.selenium;

import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopPage {

	private static final String URL_SHOP_PRODUCTS = "https://awesome-boutique-9152.spree.mx/products";
	private static final String URL_FEATURED = "https://awesome-boutique-9152.spree.mx/t/featured";
	private static final String URL_BRAND = "https://awesome-boutique-9152.spree.mx/t/brand/";
	private static final String URL_CATEGORY = "https://awesome-boutique-9152.spree.mx/t/categories/";
	
	public static boolean isValidURL_oldVersion(String url) {
		if (url.startsWith(URL_SHOP_PRODUCTS))
			return true;
		if (url.startsWith(URL_FEATURED))
			return true;
		if (url.startsWith(URL_BRAND))
			return true;
		if (url.startsWith(URL_CATEGORY))
			return true;
		return false;
	}


	private static final Pattern[] VALID_URL_PATTERNS = {
		Pattern.compile("^https?://([^/]+)/products(\\?.*)?$"),
		Pattern.compile("^https?://([^/]+)/t/featured(\\?.*)?$"),
		Pattern.compile("^https?://([^/]+)/t/brand/([^/]+)(\\?.*)?$"),
		Pattern.compile("^https?://([^/]+)/t/categories/([^/+])(\\?.*)?$"),
	};
		
	public static void assertValidURL(WebDriver wd) {
		MyPages.assertValidURL(wd, VALID_URL_PATTERNS);
	}
	

	public static ShopPage goToShopProducts(WebDriver wd) {
		wd.get(URL_SHOP_PRODUCTS);
		return new ShopPage(wd);
	}
	
	public static ShopPage goToFeatured(WebDriver wd) {
		wd.get(URL_FEATURED);
		return new ShopPage(wd);
	}

	
	private final WebDriver wd; 

	public ShopPage(WebDriver wd) {
		this.wd = wd;
		assertValidURL(wd);
	}

	public BuyPage clickBuyRailsToteBag() {
		wd.findElement(MyBy.altText("Ruby on Rails Tote")).click();
		return new BuyPage(wd);
	}

	public ShopPage clickBrandSpree() {
		return clickBrand("Spree");
	}

	public ShopPage clickBrandRails() {
		return clickBrand("Rails");
	}

	public ShopPage clickBrand(String brandName) {
		wd.findElement(By.xpath("//aside[@id='sidebar']//a[.='"+brandName+"']")).click();
		return new ShopPage(wd);
	}

	public BuyPage clickBuySpreeRingerTShirt() {
		return clickBuyItem("Spree Ringer T-Shirt");
	}
	
	public BuyPage clickBuyRubyOnRailsTote() {
		return clickBuyItem("Ruby on Rails Tote");
	}

	private BuyPage clickBuyItem(String itemImageAltText) {
		wd.findElement(MyBy.altText("Spree Ringer T-Shirt")).click();
		return new BuyPage(wd);
	}

	public ShopPage selectPriceRange15to18() {
		return selectPriceRange("Price_Range_$15.00_-_$18.00");
	}

	public ShopPage selectPriceRange20andOver() {
		return selectPriceRange("Price_Range_$20.00_or_over");
	}

	public ShopPage selectPriceRange(String rangeId) {
        if (!wd.findElement(By.id(rangeId)).isSelected()) {
            wd.findElement(By.id(rangeId)).click();
        }
        wd.findElement(By.name("button")).click();  //Bonus, use a better selector.
        return new ShopPage(wd);
	}

	public CartPage clickCartLink() {
        wd.findElement(By.cssSelector("a.cart-info.full")).click();
		return new CartPage(wd);
	}



}
