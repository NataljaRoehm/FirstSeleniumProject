package com.ait.qa27;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoWebShopTests {

  WebDriver driver;
  @BeforeMethod
  public void setUp() {
    driver = new ChromeDriver();
    driver.get("https://demowebshop.tricentis.com/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
  @Test
  public void findElementByCssSelector() {
    //by id -> #id
    driver.findElements(By.cssSelector("#dialog-notifications-success"));
    driver.findElements(By.cssSelector("#bar-notification"));
    driver.findElements(By.cssSelector("#master-wrapper-page"));

    // //by class -> .class
     driver.findElements(By.cssSelector(".master-wrapper-content"));
     driver.findElements(By.cssSelector(".header-logo"));
     driver.findElements(By.cssSelector(".header-links-wrapper"));

    // //[attr = 'value']
     driver.findElement(By.cssSelector("[title='Notification']"));
     driver.findElement(By.cssSelector("[title='Error']"));
     driver.findElement(By.cssSelector("[value='Search store']"));
     driver.findElement(By.cssSelector("[title='Close']"));
  }

  @Test
  public void findElementByXpath() {
    // -> //*[@attr = 'value']
    driver.findElement(By.xpath("//*[@title='Notification']"));
    driver.findElement(By.xpath("//*[@title='Error']"));
    driver.findElement(By.xpath("//*[@value='Search store']"));
    driver.findElement(By.xpath("//*[@title='Close']"));

  //  // by id -> //*[@id='value']
    driver.findElement(By.xpath("//*[@id='newsletter-subscribe-block']"));
    driver.findElement(By.xpath("//*[@id='newsletter-email']"));

  //  // by class -> .//div[@class='value']
    driver.findElement(By.xpath(".//div[@class='header-links-wrapper']"));
    driver.findElement(By.xpath(".//div[@class='mini-shopping-cart']"));

  //  //xpath by text
    driver.findElement(By.xpath("//label[contains(.,'Excellent')]"));
   }
  @AfterMethod(enabled = true)
  public void tearDown() {
    driver.quit();
  }
}
