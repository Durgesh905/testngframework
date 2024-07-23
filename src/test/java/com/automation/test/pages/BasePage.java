package com.automation.test.pages;

import com.automation.test.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;
    public BasePage(){
        driver= DriverManager.getDriver();
        PageFactory.initElements(driver,this);
    }
}
