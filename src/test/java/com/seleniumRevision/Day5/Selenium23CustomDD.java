package com.seleniumRevision.Day5;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium23CustomDD {

    ChromeDriver driver;
        @BeforeTest
        public void openBrowser(){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            driver = new ChromeDriver(chromeOptions);
        }
        //Atomic testcases are the ones which does not have any dependency and serve single purpose
        @Test
        @Description("verify login")
        public void appVWOPositive() throws InterruptedException {
            driver.get("https://app.vwo.com");
            driver.manage().window().maximize();
            //Waits
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

            WebElement userName = driver.findElement(By.id("login-username"));
            userName.sendKeys("dilipkumar@testingacademy.com");
            WebElement password = driver.findElement(By.id("login-password"));
            password.sendKeys("Dilaxmi0017@");

            WebElement buttonLogIN = driver.findElement(By.id("js-login-btn"));
            buttonLogIN.click();


        }
       @AfterTest
      public void closeBrowser(){
          driver.quit();
      }

}

