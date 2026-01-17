package com.seleniumRevision;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Selenium15 {

    @Test(groups="QA")
    public void awesomeQA(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/practice.html");
        ////input[@name='sex' and @value='Male']
        //input[@name='lastname']

        ////select[@name='continents']


    }
}
