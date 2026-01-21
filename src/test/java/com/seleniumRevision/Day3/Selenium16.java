package com.seleniumRevision.Day3;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium16 {
    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        driver = new EdgeDriver();
        }
    //Atomic testcases are the ones which does not have any dependency and serve single purpose
    @Test
    @Description("verify login")
    public void loginInvalid(){
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("txt-username")).sendKeys("");
        driver.findElement(By.id("txt-password")).sendKeys("");
        driver.findElement(By.tagName("button")).click();
    }
    @Test
    @Description("verify login")
    public void loginValid(){
        driver.findElement(By.id("txt-username")).sendKeys("");
        driver.findElement(By.id("text-password")).sendKeys("");
        driver.findElement(By.tagName("button")).click();
    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
