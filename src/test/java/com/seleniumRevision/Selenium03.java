package com.seleniumRevision;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class Selenium03 {

    @Test
    public void addExtension(){
        EdgeOptions edgeOptions = new EdgeOptions();
        //chromeOptions.addArguments("--headless");
        edgeOptions.addExtensions(new File("/Users/Dilip/Downloads/AdBlocker.crx"));
        WebDriver driver = new EdgeDriver(edgeOptions);
        //THis only works when you have logged in to your account profile in browser
        // Not sure whether chrome supports this
        driver.get("https://youtube.com");
        System.out.println(driver.getTitle());
        //driver.quit();

        //earlier than selenium4.x
        //we need to set the driver as property manually, from 4.x, it drivers comes in-built.
        //ex: System.setProperty("webdriver.edge.driver","path/to/edgedriver.exe")
    }
}
