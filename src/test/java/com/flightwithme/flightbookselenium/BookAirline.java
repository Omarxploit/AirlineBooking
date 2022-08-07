package com.flightwithme.flightbookselenium;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookAirline {
    private static WebDriver driver = null;
    @Test
    void OpenUrl_wait_Unit_Load() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\axwxr\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        //wait until the page load
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(26));
        wait.until(pageLoadCondition);
    }
    @Test
    void EnterIntoSearchBar(){
        OpenUrl_wait_Unit_Load();
        //input into the search bar
        WebElement searchbar = driver.findElement(By.name("q"));
        searchbar.sendKeys("american airlines login");
        searchbar.submit();
    }
    @Test
    void Navigate_to_the_website(){
        EnterIntoSearchBar();
        //wait then navigate to the website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.navigate().to("https://www.aa.com/loyalty/login/optional");
    }
    @Test
    void Vertical_sroll_down(){
        Navigate_to_the_website();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
    }
    @Test
    void Guest_Login(){
        Vertical_sroll_down();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement Guest = driver.findElement(By.name("_button_login_guest"));
        Guest.click();
    }
}

