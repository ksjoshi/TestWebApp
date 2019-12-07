package com.example.demo.ui.config;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SeleniumConfig {

    protected static WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
    }

    protected WebElement getElementById(String id) {
        return driver.findElement(By.id(id));
    }

    protected WebElement getElementByClass(String cssClass) {
        return driver.findElement(By.className(cssClass));
    }

}
