package com.miniProject;

import io.qameta.allure.Description;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.time.Duration;


public class MiniProject {
    WebDriver driver;
    @BeforeTest
    public void launchBrowser(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--guest");
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);

    }
    @Test(groups="QA")
    @Description("Mini Project")
    public void miniProject() throws InterruptedException {
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        //<a id="btn-make-appointment" href="./profile.php#login"
        // class="btn btn-dark btn-lg">Make Appointment</a>
        ////a[@id="btn-make-appointment"] OR //a[text()='Make Appointment'] --xpath
        ////a#btn-make-appointment --CSS selector

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='btn-make-appointment']")));

        WebElement makeAppoint = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        makeAppoint.click();
        //https://awesomeqa.com/hr/web/index.php/auth/login
        //https://katalon-demo-cura.herokuapp.com/
        //https://app.vwo.com/#/login
        //dilipkumar@testingacademy.com
        //Dilaxmi0017@

        WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait1.until(ExpectedConditions.elementToBeClickable(By.id("btn-login")));
        WebElement uName = driver.findElement(By.id("txt-username"));
        uName.sendKeys("John Doe");

        WebElement passWord = driver.findElement(By.id("txt-password"));
        passWord.sendKeys("ThisIsNotAPassword");

        WebElement btnLogin = driver.findElement(By.id("btn-login"));
        btnLogin.click();
        WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(8));
        wait2.until(ExpectedConditions.elementToBeClickable(By.name("facility")));

        WebElement dropDown = driver.findElement(By.name("facility"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Seoul CURA Healthcare Center");
        //visit date -- //input[@placeholder='dd/mm/yyyy'] --xpath
        WebElement calendar = driver.findElement(By.name("visit_date"));
        calendar.sendKeys("22/01/2026");

        WebElement comment = driver.findElement(By.name("comment"));
        comment.sendKeys("This is my First Mini Project");

        WebElement bookAppoint = driver.findElement(By.xpath("//button[text()='Book Appointment']"));
        bookAppoint.click();

        String actual = driver.findElement(By.xpath("//p[@id='facility']")).getText();
        String bookingComment = driver.findElement(By.xpath("//p[@id='comment']")).getText();

        Assert.assertEquals(actual,"Seoul CURA Healthcare Center");
        Assert.assertEquals(bookingComment,"This is my First Mini Project");
        Thread.sleep(20000);
        driver.findElement(By.xpath("//a[@id='menu-toggle']")).click();

        driver.findElement(By.xpath("//a[text()='Logout']")).click();


        }

        @AfterTest
        public void tearDown(){
        driver.quit();
        }


}
