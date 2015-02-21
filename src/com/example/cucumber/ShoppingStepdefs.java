package com.example.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.example.cucumber.selenium.BuyPage;
import com.example.cucumber.selenium.CartPage;
import com.example.cucumber.selenium.HomePage;
import com.example.cucumber.selenium.ShopPage;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SuppressWarnings("unused")
public class ShoppingStepdefs {

	private WebDriver wd;

	@Before
	public void createBrowser() {
		wd = new FirefoxDriver();
	}
	
	@After
	public void closeBrowser(Scenario scenerio) {
		if (scenerio.isFailed()) {
			//Take screen shot
		} else {
			wd.quit();
		}
	}
	
	@Given("^I am on the shop page$")
	public void iVisitTheWebsite() { 
        wd.get("https://awesome-boutique-9152.spree.mx/");
		HomePage home = new HomePage(wd);
		ShopPage shop = home.clickShopPage();
	}
	
    @Given("^Items are filtered for \"Rails\" brand$")
	public void items_are_filtered_for_Ruby_brand() throws Throwable {
		ShopPage shop = new ShopPage(wd);
		shop = shop.clickBrandRails();
	}

	@Given("^Items are \"\\$15.00 - \\$18.00\"$")
	public void iClickOnShop() {
		ShopPage shop = new ShopPage(wd);
		shop = shop.selectPriceRange15to18();
	}
	
	@When("^I choose the \"Ruby on Rails Tote\"$")
	public void iChooseTheToteBag() {
		ShopPage shop = new ShopPage(wd);
		BuyPage buy = shop.clickBuyRailsToteBag();
	}
	
	@When("^I add it to the cart$")
	public void iAddItToTheCart() {
		BuyPage buy = new BuyPage(wd);
		CartPage cart = buy.clickAddToCart();
	}
	
	@Then("^\"Ruby on Rails Tote\" is in my shopping cart$")
	public void isInMyCart() {
		CartPage cart = new CartPage(wd);
		cart.assertContainsRailsToteBag();
	}
}
