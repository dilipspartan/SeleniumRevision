package com.seleniumRevision.Day6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium26 {
    WebDriver driver;
    @BeforeTest
    public void launchBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--guest");
        driver = new ChromeDriver(options);
    }

    @Test
    public void selectDropDown() throws InterruptedException {
        ////button[@class='kV1UjG']//*[local-name()='svg'] --using parent
        ////*[local-name()='svg' and @viewBox='0 0 24 24'] --same span tag
        ////*[local-name()='svg']/*[local-name='path'][1] -- has 9 paths not unique

        driver.get("https://www.flipkart.com/");
        //searchbar xpath --> //input[@placeholder='Search for Products, Brands and More']
        // OR //input[@class='lNPl8b'] OR By.className("lNPl8b");
        WebElement searchBar = driver.findElement(By.className("lNPl8b"));
        searchBar.sendKeys("mac mini");
        //WebElement searchBar = driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']"))
        WebElement search = driver.findElement(By.xpath("//button[@class='kV1UjG']//*[local-name()='svg']"));
        search.click();

    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
