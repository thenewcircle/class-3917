package com.example.cucumber.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest {
    FirefoxDriver wd;
    
    @Before
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    @Ignore
    public void firstTest() {
        wd.get("https://awesome-boutique-9152.spree.mx/");
        if (!wd.findElement(By.tagName("html")).getText().contains("$19.99")) {
            System.out.println("verifyTextPresent failed");
        }
        if (!wd.findElement(By.tagName("html")).getText().contains("ADD TO CART")) {
            System.out.println("verifyTextPresent failed");
        }
        wd.findElement(By.xpath("//div[@id='home-slider']/div/div[1]/ul/li[8]/div[2]/div[2]/form/button")).click();
    }
    
    @After
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
