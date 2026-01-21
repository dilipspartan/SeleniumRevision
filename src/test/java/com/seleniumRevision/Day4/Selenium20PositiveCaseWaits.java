package com.seleniumRevision.Day4;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium20PositiveCaseWaits {
//explicit waits
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
            //explicit wait implementation
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10000));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".page-heading")));
            WebElement headerText = driver.findElement(By.cssSelector(".page-heading"));
            //couldnt find the dashboard of name due to userID
            System.out.println("1 -> " +headerText.getText());

        }
       @AfterTest
      public void closeBrowser(){
            driver.quit();
      }

}

