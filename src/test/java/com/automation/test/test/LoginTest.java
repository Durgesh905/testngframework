package com.automation.test.test;

import com.automation.test.pages.HomePage;
import com.automation.test.pages.LoginPage;
import com.automation.test.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;
public class LoginTest extends BaseTest {

    @Test
    public void verifyUserLoginCredentials() throws IOException {
        loginPage.openWebste();
        loginPage.doLogin("standard_user", "secret_sauce");
        test.addScreenCaptureFromPath(takeScreenshot());
        Assert.assertTrue(homePage.isHomePageDisplayed(), "homepage not displayed");

    }

    @Test
    public void verifyUserCanLogout() {
        loginPage.openWebste();
        loginPage.doLogin("standard_user", "secret_sauce");
        Assert.assertTrue(homePage.isHomePageDisplayed(), "homepage not displayed");
        homePage.clickOnMenu();
        homePage.clickOnLogout();
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "username and password is not displayed");
    }

    /*@Test
    public void verifyAddToCart() {
        loginPage.openWebste();
        Assert.assertTrue(loginPage.isLoginPageDisplayed(),"login page not displayed");
        loginPage.doLogin("standard_user", "secret_sauce");
        Assert.assertTrue(homePage.isHomePageDisplayed(), "homepage not displayed");
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("remove-sauce-labs-backpack")).isDisplayed());

    }
    @Test
    public void clickProductTest() {
        loginPage.openWebste();
        loginPage.doLogin("standard_user", "secret_sauce");
        Assert.assertTrue(homePage.isHomePageDisplayed(), "homepage not displayed");
        WebElement w = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        w.click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).isDisplayed());
        WebElement e = driver.findElement(By.id("back-to-products"));
        Assert.assertTrue(e.isDisplayed());
        e.click();
        Assert.assertTrue(homePage.isHomePageDisplayed(), "homepage not displayed");
    }*/
}
