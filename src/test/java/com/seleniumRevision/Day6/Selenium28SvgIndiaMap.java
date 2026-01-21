package com.seleniumRevision.Day6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium28SvgIndiaMap {
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

        driver.get("https://www.amcharts.com/svg-maps/?map=india");


    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}


