package com.github.e999or.lesson19;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


public class SimpleTest {
    private static final Logger LOG = LoggerFactory.getLogger(SimpleTest.class);
    private WebDriver webDriver;

    @BeforeMethod
    public void beforeTestMethod() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        LOG.info("Before test method");
    }

    @AfterMethod
    public void afterTestMethod(){
        webDriver.quit();
        LOG.info("After test method");
    }

    @Test
    public void shouldAnswerWithTrue() throws InterruptedException {
       webDriver.get("https://savkk.github.io/selenium-practice/");
       Date time = new GregorianCalendar(2020, Calendar.MARCH, 16).getTime();
      // List<WebElement> list = webDriver.findElements(By.tagName("a"));
       String [] arrStr = {"button", "checkbox", "select", "form", "iframe", "alerts", "dnd", "table"};
//       for (WebElement e : list) {
//           Cookie cookie = new Cookie.Builder(e.getAttribute("id"), "done")
//                   .domain("savkk.github.io")
//                   .path("/")
//                   .expiresOn(time)
//                   .build();
//           webDriver.manage().addCookie(cookie);
//           webDriver.navigate().refresh();
//       }
        for (String e : arrStr) {
            Cookie cookie = new Cookie.Builder(e, "done")
                   .domain("savkk.github.io")
                   .path("/")
                   .expiresOn(time)
                   .build();
           webDriver.manage().addCookie(cookie);
           webDriver.navigate().refresh();
        }
    }
}