package com.seleniumRevision;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Selenium06 {
    public static void main(String[] args) {
        //EdgeOptions options = new EdgeOptions();
        //options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        // -->waits until the page is loaded completely
        //A proxy server acts as an intermediary for requests between a client and a server. In simple, the traffic flows through the proxy server on its way to the address you requested and back.
//        Java Code Implementation:

                ChromeOptions options = new ChromeOptions();
                Proxy proxy = new Proxy();
                proxy.setHttpProxy("127.40.185.42:1080");

                options.setCapability("proxy", proxy);
                WebDriver driver = new ChromeDriver(options);
                driver.get("https://www.google.com/");
                driver.manage().window().maximize();
                driver.quit();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        //-->does not wait to load the entire page
        WebDriver driver1 = new ChromeDriver(options);
        driver1.get("https://sdet.live");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
