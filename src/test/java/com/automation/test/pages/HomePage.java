package com.automation.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.automation.test.utils.DriverManager.driver;

public class HomePage {

    public void clickOnMenu(){
        WebElement burgerMenu=driver.findElement(By.id("react-burger-menu-btn"));
        burgerMenu.click();
    }
    public void clickOnLogout(){
        WebElement logoutlink= driver.findElement(By.id("logout_sidebar_link"));
        logoutlink.click();

    }
    public boolean isHomePageDisplayed(){
        WebElement filterDropdown=driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        WebElement cartIcon=driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
       return filterDropdown.isDisplayed() && cartIcon.isDisplayed();


    }
}
