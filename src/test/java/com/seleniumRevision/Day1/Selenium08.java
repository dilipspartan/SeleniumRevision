package com.seleniumRevision.Day1;

import org.openqa.selenium.edge.EdgeDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Selenium08 {
    public static void main(String[] args) throws MalformedURLException {
        EdgeDriver driver = new EdgeDriver(); //Not Dynamic dispatch
        driver.get("https://bing.com"); // we cannot naviagte back and forward using get.


        driver.navigate().to("https://linkedin.com");
        driver.navigate().to(new URL("https://instagram.com"));
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();

    }
}
