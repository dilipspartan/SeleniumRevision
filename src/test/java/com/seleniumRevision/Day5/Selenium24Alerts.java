package com.seleniumRevision.Day5;

import io.qameta.allure.Description;
import net.bytebuddy.dynamic.TypeResolutionStrategy;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium24Alerts {

    ChromeDriver driver;
    @BeforeTest
    public void openBrowser(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
    }
    @Test (enabled = false)
    @Description("verify alert OK")
    public void alertsTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        WebElement pop = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
        pop.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        String result = driver.findElement(By.cssSelector("#result")).getText();
        System.out.println(result);

        Assert.assertEquals(result,"You successfully clicked an alert");
        Thread.sleep(2000);
        }
    @Test(enabled = false)
    @Description("verify alert of OK & cancel Buttons")
    public void alertsTest2() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        ////button[@onclick='jsConfirm()'] -- xpath
        //button[onclick='jsConfirm()'] OR [onclick='jsConfirm()'] -- cssSelector
        //
        WebElement pop2 = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        pop2.click();

        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        //cssSelector -- #result
        //xpath -- //p[@id='result'] OR //p[text()='You clicked: Cancel'] OR
        // //p[contains(text(),'Cancel')] OR //p[normalize-space()='You clicked: Cancel']

        String result = driver.findElement(By.cssSelector("#result")).getText();
        System.out.println(result);

        Assert.assertEquals(result,"You clicked: Cancel");
        Thread.sleep(2000);
    }

    @Test(enabled = false)
    public void alertTest3() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement alert3 = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
        alert3.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        String result = driver.findElement(By.xpath("//p[text()='You clicked: Ok']")).getText();

        System.out.println(result);

        Assert.assertEquals(result,"You clicked: Ok");
    }
    @Test
    public void alertSendKeys1() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // [onclick='jsPrompt()'] -- cssSelector OR button[onclick='jsPrompt()']
        WebElement alert4 = driver.findElement(By.cssSelector("[onclick='jsPrompt()']"));
        alert4.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        String result = driver.findElement(By.xpath("//p[@id='result']")).getText();

        System.out.println(result);

        Assert.assertEquals(result,"You entered: null");
    }
    @Test(enabled = false)
    public void alertSendKeys2(){
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement alert5 = driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));
        alert5.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello, Iam Dilip Kumar");
        alert.accept();

        String alertResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        System.out.println(alertResult);

        Assert.assertEquals(alertResult,"You entered: Hello, Iam Dilip Kumar");
    }



    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}

