package com.automation.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage extends BasePage {
    @FindBy(id="user-name")
            WebElement userInput;
    @FindBy(id="password")
            WebElement passwordInput;
    @FindBy(id="login-button")
            WebElement signinButton;



    public void openWebste(){
        driver.get("https://www.saucedemo.com/");
    }
    public void doLogin(String usename, String password){
        userInput.sendKeys(usename);
        passwordInput.sendKeys(password);
        signinButton.click();
    }
    public boolean isLoginPageDisplayed(){
        return driver.findElement(By.xpath("//*[@id=\"user-name\"]")).isDisplayed() && driver.findElement(By.xpath("//*[@id=\"password\"]")).isDisplayed();
    }
}
