package com.seleniumRevision;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium10 {
    @Test(groups="QA")
    @Description("Verify the Error message upon invalid login")
    public void appVWOLogin()  {
        WebDriver driver = new EdgeDriver();
        //Navigate to the url
        driver.get("https://app.vwo.com");
        //FInd webelements username and password
        WebElement userName = driver.findElement(By.id("login-username"));
        userName.sendKeys("admin@admin.com");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin");

        WebElement loginButton = driver.findElement(By.id("js-login-btn"));
        loginButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement error_msg = driver.findElement(By.className("notification-box-description"));
        String error = error_msg.getText();
        Assert.assertEquals(error,"Your email, password, IP address or location did not match");

        driver.quit();
    }
}
