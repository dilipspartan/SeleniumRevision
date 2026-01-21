package com.seleniumRevision.Day1;

import org.openqa.selenium.edge.EdgeDriver;

public class Selenium07 {
    public static void main(String[] args) {

        EdgeDriver driver = new EdgeDriver();
        driver.get("http://sdet.live");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.quit();//closes all window, driver session is closed & session ID is null
        //driver.close();
        //closes the current tab or browser window.--here driver session is open,
        // so session ID becomes invalid not null
    }
}
