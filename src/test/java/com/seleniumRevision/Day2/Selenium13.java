package com.seleniumRevision.Day2;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Selenium13 {

    @Test(groups="QA")
    @Description("Login using xapth locators")
    public void bookAppointment() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement btn_ID = driver.findElement(By.id("btn-make-appointment"));
        //WebElement bth_ClassName = driver.findElement(By.className("btn btn-dark btn-lg"));
        //WebElement bth_HREF = driver.findElement(By.xpath("href=./profile.php#login"));
        //WebElement btn_PartialLinkText = driver.findElement(By.partialLinkText("Make"));
        //WebElement btn_LinkText = driver.findElement(By.linkText("Make Appointment"));
        //WebElement bth_tagName = driver.findElement(By.tagName("a"));
        //not recommended as it can contain many a
        btn_ID.click();
        //Assert the current URL after login
        //https://katalon-demo-cura.herokuapp.com/profile.php#login
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");

        //<input type="text" -not recommended (NR)
        // class="form-control" - NR
        // id="txt-username" - R
        // name="username" - R
        // placeholder="Username" - R
        // value="" - NR
        // autocomplete="off"> - NR
        //driver.findElement(By.xpath("input[@id='txt-username']"));

        //What if we dont have unique values we go with list of elements
        List<WebElement> username = driver.findElements(By.xpath("//input[@placeholder='Username']"));
        username.get(1).sendKeys("John Doe");

        WebElement password = driver.findElement(By.id("txt-password"));
        password.sendKeys("ThisIsNotAPassword");

        driver.findElement(By.tagName("button")).click();

    }
}
