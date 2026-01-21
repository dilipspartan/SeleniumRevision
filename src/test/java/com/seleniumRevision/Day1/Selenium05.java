package com.seleniumRevision.Day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium05 {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        WebDriver sele  = new EdgeDriver();
        // this will open 2 new browser windows
        driver.get("http://google.com");
        // this wont work because http is mandatory as per w3c webdriver protocol;
    }
}
