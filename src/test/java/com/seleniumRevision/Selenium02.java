package com.seleniumRevision;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Selenium02 {
    @Test
    @Description("Verify the login with correct credentials")
    public void TestCase1(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://selenium.dev");
        System.out.println(driver.getTitle());
    }

}
