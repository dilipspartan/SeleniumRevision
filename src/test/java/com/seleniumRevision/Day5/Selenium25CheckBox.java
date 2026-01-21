package com.seleniumRevision.Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium25CheckBox {
    ChromeDriver driver;
    @BeforeTest
    public void openBrowser(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
    }
    @Test
    public void checkBox() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().maximize();


        List<WebElement> checkBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
        WebElement ch;
        try {
            ch = checkBox.get(0);
            System.out.println(ch.isEnabled());
            Thread.sleep(2000);
            ch.click();
           System.out.println(ch.isEnabled());
        }
        catch (Exception e){
            System.out.println(e);
        }
        Thread.sleep(8000);




    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }


}
