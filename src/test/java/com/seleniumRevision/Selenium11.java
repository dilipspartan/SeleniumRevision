package com.seleniumRevision;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class Selenium11 {

    @Test
    public void loginTest11(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com");
       // WebElement link = driver.findElement(By.linkText("Start a free trial"));
        WebElement partialLink = driver.findElement(By.partialLinkText("Start"));
        System.out.println(partialLink.getAttribute("href"));//get attribute
        //System.out.println(link.getAttribute(name:"href"));
        //link.click();
        partialLink.click();

    }
}
