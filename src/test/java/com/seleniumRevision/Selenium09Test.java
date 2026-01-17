package com.seleniumRevision;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class Selenium09Test {

    WebDriver driver;
    //Launch browser
    // navigate to app.vwo.com
    //verify the url


    @Test(groups="QA")
    @Description("Verify the URL")
    public void appVWOLogin(){
        driver = new EdgeDriver();
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());
        driver.getCurrentUrl();
        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");

       // driver.quit();
    }

    @Test (groups="QA")
    @Description("Verify the Invalid username")
    public void invalidUsername() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com");

        WebElement userName = driver.findElement(By.id("login-username"));
        userName.sendKeys("admin@admin.com");

        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("admin");

        driver.findElement(By.id("js-login-btn")).click();

        Thread.sleep(2000);

        WebElement errorMsg = driver.findElement(By.id("js-notification-box-msg"));
        String eMsg = errorMsg.getText();

        Assert.assertEquals(eMsg, "Your email, password, IP address or location did not match");
    }

    @AfterMethod
    public void tearDown(){
    if (driver!=null){
        driver.quit();
    }
    }
}

