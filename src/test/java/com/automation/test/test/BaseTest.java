package com.automation.test.test;

import com.automation.test.pages.HomePage;
import com.automation.test.pages.LoginPage;
import com.automation.test.utils.ConfigReader;
import com.automation.test.utils.DriverManager;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.utils.FileUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.ExtentTest;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    private static ExtentReports extentReport;
    public static ExtentTest test;
    private static ExtentSparkReporter sparkReporter;

    @BeforeMethod
    public void setUp() throws IOException {
        String reportPath=System.getProperty("user.dir") + "\\reports\\extentReport.html";
        sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setTheme(Theme.DARK);

        extentReport=new ExtentReports();
        test=extentReport.createTest("verify user can login");
        test.info("Navigating to another page");
        ConfigReader.initConfig();
        DriverManager.createDriver();
        loginPage=new LoginPage();
        homePage=new HomePage();
    }
    @AfterMethod
    public void clanUp(){
        extentReport.attachReporter(sparkReporter);
        extentReport.flush();
        DriverManager.getDriver().quit();
    }
    public String takeScreenshot() throws IOException {
        TakesScreenshot ts =(TakesScreenshot) DriverManager.getDriver();
        File file=ts.getScreenshotAs(OutputType.FILE);
        String filePath = "src/test/resources"+"/screenshot.png";
       FileUtils.copyFile(file,new File(filePath));
        return System.getProperty("user.dir") + "/" + filePath;
    }

}

