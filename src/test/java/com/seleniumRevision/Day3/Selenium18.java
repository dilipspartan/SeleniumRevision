package com.seleniumRevision.Day3;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium18 {

            ChromeDriver driver;
        @BeforeTest
        public void openBrowser(){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            driver = new ChromeDriver(chromeOptions);
        }
        //Atomic testcases are the ones which does not have any dependency and serve single purpose
        @Test
        @Description("verify login")
        public void eBay() throws InterruptedException {
            driver.manage().window().maximize();
            driver.get("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");
            WebElement searchBox = driver.findElement(By.xpath("//input[@id='gh-ac']"));
            searchBox.sendKeys("macmini");
            WebElement searchBoxButton = driver.findElement(By.cssSelector("button[value='Search']"));
            searchBoxButton.click();

            Thread.sleep(3000); //we will replace it with wait in future

            List<WebElement> searchedTitles = driver.findElements(By.className("s-card__title"));
            ////div[@class='s-card__title'] --xpath
            /*System.out.println("Total titles found::" +searchedTitles.size());
            for(WebElement title: searchedTitles){
                System.out.println(title.getText());
            }
            Thread.sleep(2000);
*/
        //we can add a forloop to find the 10th element in the list and click it
            int i = 0; // for getting particular nth element and click it
            for(WebElement titles: searchedTitles){
                System.out.println(i + "->" + titles.getText());

                if(i == 10){
                    System.out.println(titles.getText());
                    titles.click();
                }
                i++;
            }






        }
       @AfterTest
        public void closeBrowser(){
            driver.quit();
        }

}

