package com.seleniumRevision.Day5;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium22 {

        EdgeDriver driver;
        @BeforeTest
        public void openBrowser(){
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            edgeOptions.addArguments("--guest");
            driver = new EdgeDriver(edgeOptions);
        }
        //Atomic testcases are the ones which does not have any dependency and serve single purpose
        @Test
        @Description("verify login")
        public void appVWOPositive() throws InterruptedException {
            driver.get("https://the-internet.herokuapp.com/dropdown");
            driver.manage().window().maximize();
            //static select dropdowns
            WebElement dropDown = driver.findElement(By.id("dropdown"));
            Select select = new Select(dropDown);
           //select.selectByIndex(0);--> we cannot select a disabled option
           // select.selectByValue("1");
            select.selectByVisibleText("Option 2");
            Thread.sleep(2000);


        }
        @AfterTest
        public void closeBrowser(){
            driver.quit();
        }

    }


