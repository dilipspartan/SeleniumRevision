package com.seleniumRevision;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Selenium14 {
    //whenever a tag which have a text other than anchor tag we use text() function to find the xpath

        @Test(groups="QA")
        @Description("Login using xapth locators")
        public void bookHerokuApp() {
            WebDriver driver = new EdgeDriver();
            driver.get("https://katalon-demo-cura.herokuapp.com/");
            driver.findElement(By.xpath("//a [contains(text(),'Make') and @id='btn-make-appointment']")).click();
        }//we can use mathematical operators in xpath
    }





