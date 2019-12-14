package com.example.demo.ui.config;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.net.URL;

@SpringBootTest
public class SeleniumConfig {

    protected static WebDriver driver;

  @BeforeEach
  public void setUp() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("headless");
    URL url = this.getClass().getClassLoader().getResource("chromedriver");
    File file = new File(url.getFile()); // Strangely, URL.getFile does not return a File
    ChromeDriverService.Builder bldr = (new ChromeDriverService.Builder())
            .usingDriverExecutable(file)
            .usingAnyFreePort();
     driver = new ChromeDriver(bldr.build(), options);
  }

  protected WebElement getElementById(String id) {
    return driver.findElement(By.id(id));
  }

  protected WebElement getElementByClass(String cssClass) {
    return driver.findElement(By.className(cssClass));
  }

}
