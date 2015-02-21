package com.example.cucumber.selenium;

import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	public static final Pattern[] VALID_URL_PATTERNS = {
		Pattern.compile("https://([^/]+)/cart"),
	};
	
	public static void assertValidURL(WebDriver wd) {
		MyPages.assertValidURL(wd, VALID_URL_PATTERNS);
	}
	
	private final WebDriver wd;
	
	@FindBy(css="a.continue")
	private WebElement continueButton;
	
	public CartPage(WebDriver wd) {
		this.wd = wd;
		assertValidURL(wd);
		PageFactory.initElements(wd, this);
	}

	public ShopPage clickContinueShopping() {
//		wd.findElement(By.cssSelector("a.continue")).click();
		continueButton.click();
		MyPages.animationPause();
		return new ShopPage(wd);
	}

	public ShopPage clickBrandSpree() {
		return clickBrand("Spree");
	}

	private ShopPage clickBrand(String brandName) {
		wd.findElement(By.xpath("//aside[@id='topbar']//a[.='"+brandName+"']")).click();
		return new ShopPage(wd);
	}

	public String getTotal() {
		String total = wd.findElement(By.className("cart-total")).getText();
		return total;
	}

	public void assertTotal(String string) {
		String total = this.getTotal();
		MyAssert.contains("$35.98", total);
	}

	public void assertContainsRailsToteBag() {
		assertContainsItem("/products/ruby-on-rails-tote");
	}

	private void assertContainsItem(String itemName) {
		String xpath = ".//*[@class='cart-item-description']//a[@href='" + itemName + "']";
		wd.findElement(By.xpath(xpath));
	}
}
