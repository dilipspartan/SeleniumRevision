package com.seleniumRevision.Day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Selenium04 {

    public static void main(String[] args){
        EdgeOptions edgeOptions = new EdgeOptions();
        //edgeOptions.addArguments("--headless");
        edgeOptions.addArguments("--inprivate");//these argument commands are diff for every browser
        //edgeOptions.addArguments("--start-maximized");-->maximizes the window size
        //edgeOptions.addArguments("--window-size=600,400"); //-->sets window size to particular size
        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://facebook.com");

    }
}
