package com.flightwithme.flightbookselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.* ;

public class Login {
    public static WebDriver driver = null;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\axwxr\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(26));
        wait.until(pageLoadCondition);

    }
}
