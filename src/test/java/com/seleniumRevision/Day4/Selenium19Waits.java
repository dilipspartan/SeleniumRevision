package com.seleniumRevision.Day4;

import io.qameta.allure.Description;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.time.Duration;

public class Selenium19Waits {

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
        public void appVWO() throws InterruptedException {
            driver.get("https://app.vwo.com");
            driver.manage().window().maximize();
            //Waits
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

            //driver/find --1
            //driver/find--2
            //driver/find--3
            // when we are using thread.sleep(1000)-- we are stopping the JVM execution.
            //implicit wait is global wait for all the elements which we dont use
            WebElement userName = driver.findElement(By.id("login-username"));
            userName.sendKeys("abdc@admin.com");
            WebElement password = driver.findElement(By.id("login-password"));
            password.sendKeys("admin");

            WebElement buttonLogIN = driver.findElement(By.id("js-login-btn"));
            buttonLogIN.click();

            WebElement errorMsg = driver.findElement(By.id("js-notification-box-msg"));

            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
            wait.until(ExpectedConditions.textToBePresentInElement(errorMsg,"Your email, password, IP address or location did not match"));
            //wait.until(ExpectedConditions.)
            System.out.println("1 --> " +errorMsg.getText());








        }
      // @AfterTest
        //public void closeBrowser(){
      //      driver.quit();
        //}

}

