package com.seleniumRevision.Day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

import java.util.List;

public class Selenium12 {
    @Test
    public void anchorTest() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com");

        List<WebElement> list = driver.findElements(By.tagName("a"));
        //list.get(0).click();
        System.out.println(list.size());
        //list.get(1).click();

        for( WebElement element:list){
            System.out.println(element.getText());
        }

    }
}
