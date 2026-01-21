package com.seleniumRevision.Day3;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium17 {

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

            Assert.assertEquals(driver.getCurrentUrl(),"");
            Assert.assertEquals(driver.getTitle(),"");

            //CSS selectors
            //locators - id,name,className,tagName
            //partialLinkText and linkText are anchor tag finder in selenium - not locators

            // input#'login-username' (css selector) - //input[@id='login-username']--xpath
            //custom attribute:
            //  input[data-qa='value']-Css; //input[@data-qa='value']-xpath












        }
        @AfterTest
        public void closeBrowser(){
            driver.quit();
        }

}


